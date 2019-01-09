package com.shriharsh.kotlinweather.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shriharsh.kotlinweather.data.db.entity.WEATHER_LOCATION_ID
import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation

/**
 * Created on 25/12/18.
 * shriharsh
 */
@Dao
interface WeatherLocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherLocation: WeatherLocation)


    @Query("select * from weather_location where id = $WEATHER_LOCATION_ID")
    fun getLocation(): LiveData<WeatherLocation>


}