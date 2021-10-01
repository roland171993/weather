package com.keyopstech.di

import com.keyopstech.WeatherDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WeatherDetailActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeWeatherDetailActivityInjector():WeatherDetailActivity
}