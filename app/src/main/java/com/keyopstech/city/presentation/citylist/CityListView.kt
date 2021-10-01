package com.keyopstech.city.presentation.citylist

import android.widget.ListView
import com.keyopstech.city.domaine.model.City

interface CityListView {
    fun goToDetail(cityName:String)
    fun getListView():ListView?
}