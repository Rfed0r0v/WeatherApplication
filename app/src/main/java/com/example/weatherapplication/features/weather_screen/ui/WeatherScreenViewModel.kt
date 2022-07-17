package com.example.weatherapplication.features.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.base.BaseViewModel
import com.example.weatherapplication.base.Event
import com.example.weatherapplication.features.weather_screen.WeatherInteractor

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {
    suspend fun getWeather(): String {
        return interactor.getWeather()
    }

    override fun initialViewState(): ViewState = ViewState(title = "hello", temperature = "")

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                val temperature = getWeather()
                return previousState.copy(temperature = temperature)
             }
            else -> return null
        }
    }
}