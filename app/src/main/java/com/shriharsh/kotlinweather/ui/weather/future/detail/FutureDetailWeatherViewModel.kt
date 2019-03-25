package com.shriharsh.kotlinweather.ui.weather.future.detail

import com.shriharsh.kotlinweather.data.provider.UnitProvider
import com.shriharsh.kotlinweather.data.repository.ForecastRepository
import com.shriharsh.kotlinweather.internal.lazyDeferred
import com.shriharsh.kotlinweather.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
