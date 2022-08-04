package com.example.weatherapplication.features.weather_screen.data

import com.example.weatherapplication.features.weather_screen.data.model.WeatherRemoteModel
import com.example.weatherapplication.features.weather_screen.ui.model.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(temperature = this.main.temperature)