package com.example.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.watherapplication.R
import com.example.weatherapplication.features.weather_screen.ui.UiEvent
import com.example.weatherapplication.features.weather_screen.ui.ViewState
import com.example.weatherapplication.features.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: WeatherScreenViewModel by viewModel()
    private val textViewID: TextView by lazy { findViewById<TextView>(R.id.textViewId1) }
    private val fabWeather: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.viewState.observe(this, ::render)
        fabWeather.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }
    }

    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        textViewID.text = "Температура: ${viewState.temperature}"
    }
}