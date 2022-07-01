package com.example.weatherapplication.features.weather_screen.data

interface WeatherRepo {
   suspend fun getTemperature():String
}