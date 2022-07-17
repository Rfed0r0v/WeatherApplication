package com.example.weatherapplication.features.weather_screen.ui

import com.example.weatherapplication.base.Event

data class ViewState(
    val title: String,
    val temperature: String
)

sealed class UiEvent : Event {
    object OnButtonClicked : UiEvent()
}