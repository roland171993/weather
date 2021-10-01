package com.keyopstech.city.domaine.repository

import com.keyopstech.city.domaine.model.City

interface CityRepository {
    fun getCityList(): ArrayList<City>
}