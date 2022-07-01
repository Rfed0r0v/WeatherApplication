package com.example.weatherapplication.features.weather_screen.ui

import com.example.weatherapplication.features.weather_screen.WeatherInteractor

class WeatherScreenPresenter(val interactor: WeatherInteractor) {
    suspend fun getWeather(): String {
        return interactor.getWeather()

    }
}