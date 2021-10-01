package com.keyopstech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.keyopstech.city.data.CityRepositoryImpl
import com.keyopstech.city.domaine.model.City
import com.keyopstech.city.domaine.usecase.GetCityListUseCase
import com.keyopstech.city.presentation.citylist.CityListPresenter
import com.keyopstech.city.presentation.citylist.CityListView
import com.keyopstech.utils.Constant
import com.keyopstech.weather.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), CityListView {
    @Inject lateinit var presenter: CityListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter.onViewCreated(this,this)

        presenter.loadData()



    }

    override fun goToDetail(cityName: String) {
        val intent = Intent(this, WeatherDetailActivity::class.java)
        intent.putExtra(Constant.BUNDLE_NAME,cityName)
        startActivity(intent)
    }


    override fun getListView(): ListView {
        return listView
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()

    }
}