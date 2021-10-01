package com.keyopstech.weather.domain.repository

import android.widget.ImageView
import com.keyopstech.weather.domain.model.Weather
import io.reactivex.Observable

internal interface WeatherRepository {

    fun getWeatherInfo(cityName: String, apiKey: String): Observable<Weather>
    fun getWeatherIcon(iconUrl:String, iconImageView: ImageView?)

}
