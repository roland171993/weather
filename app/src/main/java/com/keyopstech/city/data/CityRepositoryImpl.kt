package com.keyopstech.city.data

import com.keyopstech.city.domaine.model.City
import com.keyopstech.city.domaine.repository.CityRepository
import com.keyopstech.weather.R
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor():CityRepository {
    override fun getCityList(): ArrayList<City> {
        var cities = ArrayList<City>()
        cities.add(City("Abidjan", R.drawable.img_ivory_coast))
        cities.add(City("Lyon", R.drawable.img_france))
        cities.add(City("Londres",R.drawable.img_england))
        return cities
    }
}