package com.shriharsh.kotlinweather.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shriharsh.kotlinweather.data.provider.UnitProvider
import com.shriharsh.kotlinweather.data.repository.ForecastRepository

/**
 * Created on 17/12/18.
 * shriharsh
 */
class CurrentWeatherViewModelFactory(
    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository, unitProvider) as T
    }
}