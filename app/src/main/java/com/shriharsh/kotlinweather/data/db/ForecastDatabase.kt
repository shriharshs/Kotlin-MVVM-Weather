package com.shriharsh.kotlinweather.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shriharsh.kotlinweather.data.db.dao.CurrentWeatherDao
import com.shriharsh.kotlinweather.data.db.dao.FutureWeatherDao
import com.shriharsh.kotlinweather.data.db.dao.WeatherLocationDao
import com.shriharsh.kotlinweather.data.db.entity.CurrentWeather
import com.shriharsh.kotlinweather.data.db.entity.FutureWeatherEntry
import com.shriharsh.kotlinweather.data.db.entity.WeatherLocation

/**
 * Created on 16/12/18.
 * shriharsh
 */


@Database(
    entities = [CurrentWeather::class, FutureWeatherEntry::class, WeatherLocation::class],
    version = 1
)
@TypeConverters(LocalDateConverter::class)
abstract class ForecastDatabase : RoomDatabase() {

    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun futureWeatherDao(): FutureWeatherDao
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