package com.keyopstech.weather.data.network.service

import com.keyopstech.weather.domain.model.Weather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRetrofitService {

    @GET("data/2.5/weather?lang=fr&units=metric")
    fun getWeatherInfo(
        @Query("q")cityName: String,
        @Query("appid") apiKey: String
    ): Observable<Weather>


}
