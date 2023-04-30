package com.example.localization

import android.app.Application
import com.example.localization.manager.LocaleManager

class MyApplication : Application() {

    private val context = this

    companion object {
        var localeManager: LocaleManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        localeManager = LocaleManager(context)
        localeManager!!.setLocale(context)
    }
}