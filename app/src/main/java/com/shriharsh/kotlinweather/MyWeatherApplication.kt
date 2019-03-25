package com.shriharsh.kotlinweather

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.google.android.gms.location.LocationServices
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
import com.shriharsh.kotlinweather.ui.weather.future.detail.FutureDetailWeatherViewModelFactory
import com.shriharsh.kotlinweather.ui.weather.future.list.FutureListWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*
import org.threeten.bp.LocalDate

/**
 * Created on 17/12/18.
 * shriharsh
 */
class MyWeatherApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyWeatherApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton {
            ForecastRepositoryImpl(
                instance(),
                instance(),
                instance(),
                instance(),
                instance()
            )
        }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
        bind() from factory { detailDate: LocalDate -> FutureDetailWeatherViewModelFactory(detailDate, instance(), instance()) }

    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}