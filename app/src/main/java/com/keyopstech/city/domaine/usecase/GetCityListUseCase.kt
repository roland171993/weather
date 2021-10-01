package com.keyopstech.city.domaine.usecase

import com.keyopstech.city.data.CityRepositoryImpl
import com.keyopstech.city.domaine.model.City
import com.keyopstech.city.domaine.repository.CityRepository
import javax.inject.Inject

class GetCityListUseCase @Inject constructor(private val cityRepository: CityRepositoryImpl) {
    fun execute(): ArrayList<City>{
        return cityRepository.getCityList()
    }
}