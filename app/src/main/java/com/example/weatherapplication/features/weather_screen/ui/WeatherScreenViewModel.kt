package com.example.weatherapplication.features.weather_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.base.BaseViewModel
import com.example.weatherapplication.base.Event
import com.example.weatherapplication.features.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState =
        ViewState(isLoading = false, title = "hello", temperature = "")

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.onWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.onWeatherFetchSucceed(temperature = it.temperature))
                        }
                    )
                }
                return previousState.copy(isLoading = true)
            }
            is DataEvent.onWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }
            else -> return null
        }
    }
}

