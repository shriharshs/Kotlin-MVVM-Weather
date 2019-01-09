package com.shriharsh.kotlinweather.data.provider

import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation

class LocationProviderImpl : LocationProvider {
    override suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocation): Boolean {
        return true
    }

    override suspend fun getPreferredLocationString(): String {
        return "Bengaluru"
    }
}