package com.shriharsh.kotlinweather.data.provider

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created on 11/1/19.
 * shriharsh
 */
abstract class PreferenceProvider(context: Context) {
    private val appContext = context.applicationContext

    protected val preferences: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)
}