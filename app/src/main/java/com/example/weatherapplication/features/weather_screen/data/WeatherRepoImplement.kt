package com.example.weatherapplication.features.weather_screen.data

class WeatherRepoImplement(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(): String {
        return weatherRemoteSource.getWeather().main.temperature
    }

}