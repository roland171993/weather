package com.keyopstech.city

import android.widget.ListView
import com.keyopstech.city.data.CityRepositoryImpl
import com.keyopstech.city.domaine.model.City
import com.keyopstech.city.domaine.usecase.GetCityListUseCase
import com.keyopstech.city.presentation.citylist.CityListPresenter
import com.keyopstech.city.presentation.citylist.CityListView

class CityListPresenterTester:CityListView {
    private var presenter:CityListPresenter = CityListPresenter(GetCityListUseCase(
        CityRepositoryImpl()
    ))

    override fun goToDetail(cityName: String) {

    }


    override fun getListView(): ListView? {
        return null
    }

    fun loadData(){
        presenter.loadData()
    }

    fun verifyEmptyOrNull():Boolean{
        presenter.getCityList()?.let {
            return it.size == 0
        }
        return true
    }

    fun getFirstItem():City?{
        presenter.getCityList()?.let {
            return it[0]
        }
        return null
    }


}