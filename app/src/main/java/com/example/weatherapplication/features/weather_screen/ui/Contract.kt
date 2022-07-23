package com.example.weatherapplication.features.weather_screen.ui

import com.example.weatherapplication.base.Event

data class ViewState(
    val isLoading:Boolean,
    val title: String,
    val temperature: String
)

sealed class UiEvent : Event {
    object OnButtonClicked : UiEvent()
}

sealed class DataEvent : Event {
    data class onWeatherFetchSucceed(val temperature: String):DataEvent()
    data class onWeatherFetchFailed(val error: Throwable): DataEvent()
}