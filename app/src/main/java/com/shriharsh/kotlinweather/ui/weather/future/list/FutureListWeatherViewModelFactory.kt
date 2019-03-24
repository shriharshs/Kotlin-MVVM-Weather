package com.shriharsh.kotlinweather.ui.weather.future.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shriharsh.kotlinweather.data.provider.UnitProvider
import com.shriharsh.kotlinweather.data.repository.ForecastRepository

/**
 * Created on 24/03/19.
 * shriharsh
 */


class FutureListWeatherViewModelFactory(
    private val futureRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FutureListWeatherViewModel(futureRepository, unitProvider) as T
    }
}