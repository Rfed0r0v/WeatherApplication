package com.example.weatherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.watherapplication.R
import com.example.weatherapplication.features.weather_screen.WeatherInteractor
import com.example.weatherapplication.features.weather_screen.data.WeatherAPIClient
import com.example.weatherapplication.features.weather_screen.data.WeatherRemoteSource
import com.example.weatherapplication.features.weather_screen.data.WeatherRepo
import com.example.weatherapplication.features.weather_screen.data.WeatherRepoImplement
import com.example.weatherapplication.features.weather_screen.ui.WeatherScreenPresenter

class MainActivity : AppCompatActivity() {
    private val presenter = WeatherScreenPresenter(
        WeatherInteractor(
            WeatherRepoImplement(
                WeatherRemoteSource(WeatherAPIClient.getApi())
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewID = findViewById<TextView>(R.id.textViewId1)
        textViewID.text = presenter.getWeather()
    }
}