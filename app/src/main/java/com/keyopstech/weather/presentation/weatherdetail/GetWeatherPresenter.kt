package com.keyopstech.weather.presentation.weatherdetail


import com.keyopstech.utils.Constant
import com.keyopstech.weather.domain.usecase.GetWeatherUseCase
import java.util.concurrent.CountDownLatch
import javax.inject.Inject


/**
 * Created on 5/4/17.
 */
class GetWeatherPresenter @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase) {
  private var view: GetWeatherView? = null

  fun downloadAndShowWeather(latch:CountDownLatch?) {
    view?.let {viewNonNull ->
      val city = viewNonNull.getCitySelected()
      var iconImageView = viewNonNull.getIconImageView()
      city?.let {
        viewNonNull.showLoading()
        getWeatherUseCase
          .getWeatherUseCase(city,Constant.API_KEY)
          .subscribe({ weather ->
            weather?.let {
              val foundIcon = weather.weather[0].icon
              val iconUrl = Constant.ICON_URL.replace(Constant.ICON_NAME,foundIcon )
              getWeatherUseCase.getWeatherIcon(iconUrl, iconImageView)
              viewNonNull.hideLoading()
              viewNonNull.showLoadedWeather(weather.name,weather.main.temp.toString(),foundIcon)
            }
            latch?.let {
              it.countDown()
            }
          }, {
            //Error while downloading Weather
            viewNonNull.showDownloadError()
            latch?.let {
              it.countDown()
            }
          })
      }

    }


  }


  fun onViewCreated(view: GetWeatherView) {
    this.view = view
  }

  fun onViewDestroyed() {
    view = null
  }
}