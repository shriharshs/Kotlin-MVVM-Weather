package com.shriharsh.kotlinweather.data.network.response

import com.shriharsh.kotlinweather.data.db.entity.CurrentWeather
import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation

data class CurrentWeatherResponse(
    val location: WeatherLocation,
    val current: CurrentWeather
)