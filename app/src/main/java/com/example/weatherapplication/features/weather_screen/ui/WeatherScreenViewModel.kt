package com.example.weatherapplication.features.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.features.weather_screen.WeatherInteractor

class WeatherScreenViewModel(val interactor: WeatherInteractor) : ViewModel() {
    suspend fun getWeather(): String {
        return interactor.getWeather()
    }
}