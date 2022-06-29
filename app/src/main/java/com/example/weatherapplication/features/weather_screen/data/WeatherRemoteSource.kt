package com.example.weatherapplication.features.weather_screen.data

import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherAPI) {
    // TODO Add query
    fun getWeather(): Response<String> {
        return api.getWeather(query = "Moskow")
    }
}