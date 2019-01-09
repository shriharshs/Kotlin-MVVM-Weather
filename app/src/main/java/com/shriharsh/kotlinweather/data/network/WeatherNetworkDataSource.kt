package com.shriharsh.kotlinweather.data.network

import androidx.lifecycle.LiveData
import com.shriharsh.kotlinweather.data.network.response.CurrentWeatherResponse

/**
 * Created on 16/12/18.
 * shriharsh
 */
interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}