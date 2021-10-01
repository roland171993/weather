package com.keyopstech.weather.domain.usecase

import android.widget.ImageView
import com.keyopstech.weather.data.network.WeatherRepositoryImpl
import com.keyopstech.weather.domain.model.Weather
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepositoryImpl) {
    fun getWeatherUseCase(cityName: String, apiKey: String): Observable<Weather> {
        return weatherRepository
            .getWeatherInfo(cityName,apiKey)
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getWeatherIcon(iconUrl:String, iconImageView: ImageView?){
        weatherRepository.getWeatherIcon(iconUrl,iconImageView)
    }
}
