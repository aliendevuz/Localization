package com.example.localization.manager

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.LocaleList
import java.util.*

@Suppress("DEPRECATION")
class LocaleManager(context: Context) {

    private val preferences = PreferencesManager.getInstance(context)

    companion object {
        const val LANGUAGE_CHINESE = "zh"
        const val LANGUAGE_KOREAN = "ko"
        const val LANGUAGE_JAPAN = "ja"
        const val LANGUAGE_UZBEK = "uz"
        private const val LANGUAGE_KEY = "language"

        fun isAtLeastVersion(version: Int): Boolean {
            return Build.VERSION.SDK_INT >= version
        }
    }

    private val language = if (preferences.loadString(LANGUAGE_KEY) != "null") preferences.loadString(LANGUAGE_KEY) else LANGUAGE_UZBEK

    private fun persistLanguage(language: String) {
        preferences.saveString(LANGUAGE_KEY, language)
    }

    fun setLocale(context: Context): Context {
        return update(context, language)
    }

    private fun update(context: Context, language: String?): Context {
        updateResources(context, language)
        val appContext = context.applicationContext
        if (context != appContext)
            updateResources(appContext, language)
        return appContext
    }

    fun setNewLocale(context: Context, language: String) {
        persistLanguage(language)
        update(context, language)
    }

    private fun updateResources(context: Context, language: String?) {
        val locale = Locale(language!!)
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res.configuration)
        if (isAtLeastVersion(VERSION_CODES.N))
            setLocaleForApi24(config, locale)
        else if (isAtLeastVersion(VERSION_CODES.JELLY_BEAN_MR1))
            config.setLocale(locale)
        else
            config.locale = locale
        res.updateConfiguration(config, res.displayMetrics)
    }

    private fun setLocaleForApi24(config: Configuration, locale: Locale) {
        val set = LinkedHashSet<Locale>()
        set.add(locale)
        val all = LocaleList.getDefault()
        for (i in 0 until all.size()) set.add(all[i])
        val locales = set.toTypedArray()
        config.setLocales(LocaleList(*locales))
    }
}