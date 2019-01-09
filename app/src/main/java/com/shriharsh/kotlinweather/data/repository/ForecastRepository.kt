package com.shriharsh.kotlinweather.data.repository

import androidx.lifecycle.LiveData
import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation
import com.shriharsh.kotlinweather.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

/**
 * Created on 16/12/18.
 * shriharsh
 */
interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}