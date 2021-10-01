package com.keyopstech.di

import com.keyopstech.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    MainActivityModule::class,
    WeatherDetailActivityModule::class,
    AndroidInjectionModule::class,
    AppModule::class
])
interface AppComponent {

    fun inject(application: App)
}