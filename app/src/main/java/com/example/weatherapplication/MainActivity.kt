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
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: WeatherScreenViewModel by viewModel()
    private val textViewID: TextView by lazy { findViewById<TextView>(R.id.textViewId1) }
    private val fabWeather: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }
    private val collapsingToolbar:CollapsingToolbarLayout by lazy{findViewById(R.id.collapsingToolbar)}
    private val weatherAppBar:AppBarLayout by lazy {findViewById(R.id.weatherAppBar)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.viewState.observe(this, ::render)

        weatherAppBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percent = (kotlin.math.abs(appBarLayout.totalScrollRange + verticalOffset)
                .toFloat() / appBarLayout.totalScrollRange)
            fabWeather.alpha = percent
        }

        fabWeather.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }
    }

    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        collapsingToolbar.title = "Температура: ${viewState.temperature}"
        textViewID.text = "Температура: ${viewState.temperature}"
    }
}