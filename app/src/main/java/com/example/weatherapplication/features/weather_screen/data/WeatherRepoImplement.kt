package com.example.weatherapplication.features.weather_screen.data

class WeatherRepoImplement(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override fun getTemperature(): String {
        return weatherRemoteSource.getWeather().message()
    }

}