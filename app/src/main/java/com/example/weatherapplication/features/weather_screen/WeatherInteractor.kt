package com.example.weatherapplication.features.weather_screen

import com.example.weatherapplication.base.Either
import com.example.weatherapplication.base.attempt
import com.example.weatherapplication.features.weather_screen.data.WeatherRepo
import com.example.weatherapplication.features.weather_screen.ui.model.WeatherModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): Either<Throwable,WeatherModel> {
        return attempt { weatherRepo.getTemperature() }

    }
}