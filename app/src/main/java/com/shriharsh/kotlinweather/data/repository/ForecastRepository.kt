package com.shriharsh.kotlinweather.data.repository

import androidx.lifecycle.LiveData
import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation
import com.shriharsh.kotlinweather.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import com.shriharsh.kotlinweather.data.db.unitlocalized.future.detail.UnitSpecificDetailFutureWeatherEntry
import com.shriharsh.kotlinweather.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

/**
 * Created on 16/12/18.
 * shriharsh
 */
interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getFutureWeatherList(
        startDate: LocalDate,
        metric: Boolean
    ): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>

    suspend fun getFutureWeatherByDate(date: LocalDate, metric: Boolean): LiveData<out UnitSpecificDetailFutureWeatherEntry>

    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}