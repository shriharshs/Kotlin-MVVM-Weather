package com.shriharsh.kotlinweather.data.network.response

import com.google.gson.annotations.SerializedName
import com.shriharsh.kotlinweather.data.db.entity.FutureWeatherEntry

/**
 * Created on 11/1/19.
 * shriharsh
 */
data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)