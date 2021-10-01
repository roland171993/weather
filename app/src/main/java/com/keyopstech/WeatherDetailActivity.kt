package com.keyopstech

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.keyopstech.weather.data.network.WeatherRepositoryImpl
import com.keyopstech.weather.domain.usecase.GetWeatherUseCase
import com.keyopstech.utils.Constant
import com.keyopstech.utils.Utils
import com.keyopstech.weather.R
import com.keyopstech.weather.presentation.weatherdetail.GetWeatherPresenter
import com.keyopstech.weather.presentation.weatherdetail.GetWeatherView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_weather_detail.*
import javax.inject.Inject


class WeatherDetailActivity : AppCompatActivity(), GetWeatherView {
    var cityName:String? = null

    @Inject lateinit var presenter: GetWeatherPresenter


    override fun onCreate(savedInstanceState: Bundle?)
    {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)

        // Show Toolbar
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        // Get City Selected
        cityName = intent.getStringExtra(Constant.BUNDLE_NAME)
        if (cityName == null){
            cityName = ""
            Utils.showToast(this, R.string.error_bad_city)
        }else{
            // Remove Left and Right Space in String
            cityName = cityName.toString().trim()

            presenter.onViewCreated(this)
            presenter.downloadAndShowWeather(null)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()

    }

    override fun getCitySelected(): String? {
        return  cityName
    }

    override fun getIconImageView(): ImageView? {
        return iconImageView
    }

    override fun showLoadedWeather(city: String, temperature: String, icon: String) {
        cityTextView.text = city
        temperatureTextView.text = temperature
    }


    override fun showDownloadError() {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        // Show Progress Bar and Hide Detail
        detailLinearLayout.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
        detailLinearLayout.visibility = View.VISIBLE
    }
}