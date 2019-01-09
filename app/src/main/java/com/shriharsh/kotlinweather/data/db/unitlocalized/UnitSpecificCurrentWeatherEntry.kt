package com.shriharsh.kotlinweather.data.db.unitlocalized

/**
 * Created on 16/12/18.
 * shriharsh
 */
interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}