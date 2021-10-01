package com.keyopstech.weather.domain.model

data class WeatherItem(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
