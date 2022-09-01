package com.example.weatherapplication.features.weather_screen.data

import com.example.weatherapplication.features.weather_screen.data.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherAPI) {
    // TODO Add query
    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Liski")
    }
}