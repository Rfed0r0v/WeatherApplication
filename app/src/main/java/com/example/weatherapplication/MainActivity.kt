package com.example.weatherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.watherapplication.R
import com.example.weatherapplication.features.weather_screen.WeatherInteractor
import com.example.weatherapplication.features.weather_screen.data.WeatherAPIClient
import com.example.weatherapplication.features.weather_screen.data.WeatherRemoteSource
import com.example.weatherapplication.features.weather_screen.data.WeatherRepo
import com.example.weatherapplication.features.weather_screen.data.WeatherRepoImplement
import com.example.weatherapplication.features.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImplement(
                    WeatherRemoteSource(WeatherAPIClient.getApi())
                )
            )
        )
        var weather = ""
        val textViewID = findViewById<TextView>(R.id.textViewId1)
        textViewID.text

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                textViewID.text = presenter.getWeather()
            }
//            Log.d("Net", presenter.interactor.getWeather())

        }


    }
}