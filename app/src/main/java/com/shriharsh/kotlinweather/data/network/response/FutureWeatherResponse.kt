package com.shriharsh.kotlinweather.data.network.response

import com.google.gson.annotations.SerializedName
import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation

/**
 * Created on 11/1/19.
 * shriharsh
 */
data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)