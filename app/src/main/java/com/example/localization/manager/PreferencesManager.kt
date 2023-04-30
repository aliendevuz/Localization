package com.example.localization.manager

import android.content.Context

class PreferencesManager(context: Context) {

    private val preferences = context.getSharedPreferences("My Preferences", Context.MODE_PRIVATE)

    companion object {
        private var preferencesManager: PreferencesManager? = null
        fun getInstance(context: Context): PreferencesManager {
            if (preferencesManager == null)
                preferencesManager = PreferencesManager(context)
            return preferencesManager!!
        }
    }

    fun saveString(key: String, value: String) {
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun saveLong(key: String, value: Long) {
        val editor = preferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun saveInteger(key: String, value: Int) {
        val editor = preferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun saveDouble(key: String, value: Double) {
        val editor = preferences.edit()
        editor.putString(key, value.toString())
        editor.apply()
    }


    fun loadString(key: String): String {
        return preferences.getString(key, "null").toString()
    }

    fun loadLong(key: String): Long {
        return preferences.getLong(key, 0L)
    }

    fun loadBoolean(key: String): Boolean {
        return preferences.getBoolean(key, false)
    }

    fun loadInteger(key: String): Int {
        return preferences.getInt(key, 0)
    }

    fun loadDouble(key: String): Double {
        return preferences.getString(key, "0.0")!!.toDouble()
    }
}