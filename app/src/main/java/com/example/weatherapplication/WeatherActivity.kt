package com.example.weatherapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.watherapplication.R

class WeatherActivity : AppCompatActivity() {
    private val weatherPresenter = WeatherPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val tvTemp = findViewById<TextView>(R.id.tvTemperature)
        tvTemp.text = weatherPresenter.getWeather()
    }
}