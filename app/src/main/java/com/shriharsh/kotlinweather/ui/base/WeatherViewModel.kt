package com.shriharsh.kotlinweather.ui.base

import androidx.lifecycle.ViewModel
import com.shriharsh.kotlinweather.data.provider.UnitProvider
import com.shriharsh.kotlinweather.data.repository.ForecastRepository
import com.shriharsh.kotlinweather.internal.UnitSystem
import com.shriharsh.kotlinweather.internal.lazyDeferred

/**
 * Created on 24/03/19.
 * shriharsh
 */

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }

}