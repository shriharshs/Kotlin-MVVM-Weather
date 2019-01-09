package com.shriharsh.kotlinweather

import android.app.Application
import android.preference.PreferenceManager
import com.jakewharton.threetenabp.AndroidThreeTen
import com.shriharsh.kotlinweather.data.ApixuWeatherApiService
import com.shriharsh.kotlinweather.data.db.ForecastDatabase
import com.shriharsh.kotlinweather.data.network.ConnectivityInterceptor
import com.shriharsh.kotlinweather.data.network.ConnectivityInterceptorImpl
import com.shriharsh.kotlinweather.data.network.WeatherNetworkDataSource
import com.shriharsh.kotlinweather.data.network.WeatherNetworkDataSourceImpl
import com.shriharsh.kotlinweather.data.provider.LocationProvider
import com.shriharsh.kotlinweather.data.provider.LocationProviderImpl
import com.shriharsh.kotlinweather.data.provider.UnitProvider
import com.shriharsh.kotlinweather.data.provider.UnitProviderImpl
import com.shriharsh.kotlinweather.data.repository.ForecastRepository
import com.shriharsh.kotlinweather.data.repository.ForecastRepositoryImpl
import com.shriharsh.kotlinweather.ui.weather.current.CurrentWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created on 17/12/18.
 * shriharsh
 */
class MyWeatherApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyWeatherApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl() }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance(), instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}