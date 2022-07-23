package com.example.weatherapplication.features.weather_screen.data

import com.example.weatherapplication.features.weather_screen.ui.model.WeatherModel

class WeatherRepoImplement(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomain()
    }

}