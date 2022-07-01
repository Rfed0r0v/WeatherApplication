package com.example.weatherapplication.features.weather_screen

import com.example.weatherapplication.features.weather_screen.data.WeatherRepo

class WeatherInteractor(private val weatherRepo: WeatherRepo) {
   suspend fun getWeather(): String {
        return weatherRepo.getTemperature()

    }
}