package com.shriharsh.kotlinweather.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shriharsh.kotlinweather.data.db.dao.CurrentWeatherDao
import com.shriharsh.kotlinweather.data.db.dao.WeatherLocationDao
import com.shriharsh.kotlinweather.data.db.entity.CurrentWeather
import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation

/**
 * Created on 16/12/18.
 * shriharsh
 */


@Database(
    entities = [CurrentWeather::class, WeatherLocation::class],
    version = 1
)
abstract class ForecastDatabase : RoomDatabase() {

    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun weatherLocationDao(): WeatherLocationDao

    companion object {
        @Volatile
        private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ForecastDatabase::class.java, "forecast.db")
                .build()
    }

}