package com.keyopstech.weather.domain.model

data class Weather(
    val weather: List<WeatherItem>,
    val main: Temperature,
    val name: String
)

