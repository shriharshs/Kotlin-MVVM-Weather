package com.shriharsh.kotlinweather.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.shriharsh.kotlinweather.data.provider.UnitProvider
import com.shriharsh.kotlinweather.data.repository.ForecastRepository
import com.shriharsh.kotlinweather.internal.UnitSystem
import com.shriharsh.kotlinweather.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }

}
