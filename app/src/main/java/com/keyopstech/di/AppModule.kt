package com.keyopstech.di

import com.keyopstech.weather.data.network.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(
    private val baseUrl:String
) {
    @Singleton
    @Provides
    fun providesWeatherRepositoryImpl(): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(baseUrl)
    }
}