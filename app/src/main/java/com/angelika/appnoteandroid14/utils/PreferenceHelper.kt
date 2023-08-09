package com.angelika.appnoteandroid14.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private var sharedPreferences: SharedPreferences? = null

    fun prefUnit(context: Context) {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)  // MODE_PRIVATE скрытие наших данных
    }

    var saveBoolean
        set(value) = sharedPreferences?.edit()?.putBoolean("Bool", value!!)?.apply()!!
        get() = sharedPreferences?.getBoolean("Bool", false)
}