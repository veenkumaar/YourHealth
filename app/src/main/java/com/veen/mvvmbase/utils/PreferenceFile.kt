package com.veen.mvvmbase.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PreferenceFile(private val context: Context) {

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(context)

    fun saveData(key: String, data: String) {
        preference.edit().putString(
            key, data
        ).apply()
    }

    fun getData(key: String): String? {
        return preference.getString(key, null)
    }
}