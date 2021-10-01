package com.keyopstech.weather.presentation.weatherdetail

import android.widget.ImageView

/**
 * Created on 5/4/17.
 */
interface GetWeatherView {
  fun getCitySelected(): String?
  fun getIconImageView(): ImageView?
  fun showLoadedWeather(city: String,temperature:String,icon:String)
  fun showDownloadError()
  fun showLoading()
  fun hideLoading()
}