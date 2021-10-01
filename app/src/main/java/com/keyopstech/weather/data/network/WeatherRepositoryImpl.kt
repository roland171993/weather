package com.keyopstech.weather.data.network

import android.widget.ImageView
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.keyopstech.utils.Constant
import com.keyopstech.weather.data.network.service.WeatherRetrofitService
import com.keyopstech.weather.domain.model.Weather
import com.keyopstech.weather.domain.repository.WeatherRepository
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class WeatherRepositoryImpl : WeatherRepository {
    var weatherRetrofitService: WeatherRetrofitService
    @Inject constructor(baseUrl:String){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        weatherRetrofitService = retrofit.create(WeatherRetrofitService::class.java)

    }

    override fun getWeatherInfo(cityName: String, apiKey: String): Observable<Weather> {
        return weatherRetrofitService.getWeatherInfo(cityName,apiKey)
            .subscribeOn(Schedulers.io())
    }

    fun getWeatherIconBase(iconUrl:String, iconImageView: ImageView?){
        iconImageView?.let {
            Picasso.get()
                .load(iconUrl)
                .into(iconImageView)
        }

    }

    override fun getWeatherIcon(iconUrl: String, iconImageView: ImageView?) {
        return getWeatherIconBase(iconUrl,iconImageView)
    }


}
