package com.example.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.watherapplication.R
import com.example.weatherapplication.features.weather_screen.ui.WeatherScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel:WeatherScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var weather = ""
        val textViewID = findViewById<TextView>(R.id.textViewId1)
        textViewID.text

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                textViewID.text = viewModel.getWeather()
            }
//            Log.d("Net", presenter.interactor.getWeather())

        }


    }
}