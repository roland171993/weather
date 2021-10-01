package com.keyopstech.weather

import android.widget.ImageView
import com.keyopstech.utils.Constant
import com.keyopstech.weather.data.network.WeatherRepositoryImpl
import com.keyopstech.weather.domain.usecase.GetWeatherUseCase
import com.keyopstech.weather.presentation.weatherdetail.GetWeatherPresenter
import com.keyopstech.weather.presentation.weatherdetail.GetWeatherView
import java.util.concurrent.CountDownLatch


class GetWeatherPresenterTester: GetWeatherView {

    private var presenter: GetWeatherPresenter = GetWeatherPresenter(
        GetWeatherUseCase(
            WeatherRepositoryImpl(Constant.BASE_URL)
        )
    )
    private var citySelected:String = ""
    var cityResponse: String =""
    var temperature: String =""
    var icon: String =""
    var errorHappen: Boolean = false
    init {
        presenter.onViewCreated(this)
    }

    fun loadData(){
        val latch = CountDownLatch(1)
        presenter.downloadAndShowWeather(latch)
        try {
            latch.await()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun setCitySelected(value:String){
        this.citySelected = value
    }

    override fun getCitySelected(): String {
        return this.citySelected
    }

    override fun getIconImageView(): ImageView? {
        return null
    }

    override fun showLoadedWeather(city: String, temperature: String, icon: String) {
        this.cityResponse = city
        this.temperature = temperature
        this.icon = icon
    }


    override fun showDownloadError() {
        this.errorHappen = true
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

}