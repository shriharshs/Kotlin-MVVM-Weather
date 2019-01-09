package com.shriharsh.kotlinweather.data.provider

import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation

/**
 * Created on 25/12/18.
 * shriharsh
 */
interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean
    suspend fun getPreferredLocationString(): String
}