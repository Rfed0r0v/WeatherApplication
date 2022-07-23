package com.example.weatherapplication.features.weather_screen.data

import com.example.weatherapplication.features.weather_screen.ui.model.WeatherModel

interface WeatherRepo {
   suspend fun getTemperature():WeatherModel
}