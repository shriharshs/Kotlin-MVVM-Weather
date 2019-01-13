package com.shriharsh.kotlinweather.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shriharsh.kotlinweather.data.db.entity.CURRENT_WEATHER_ID
import com.shriharsh.kotlinweather.data.db.entity.CurrentWeather
import com.shriharsh.kotlinweather.data.db.unitlocalized.current.ImperialCurrentWeatherEntry
import com.shriharsh.kotlinweather.data.db.unitlocalized.current.MetricCurrentWeatherEntry

/**
 * Created on 16/12/18.
 * shriharsh
 */

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(currentWeather: CurrentWeather)


    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>

}