package com.example.weatherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.watherapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewTemp = findViewById<TextView>(R.id.textViewTemp)
        val textViewWind = findViewById<TextView>(R.id.textViewWind)
        val textViewTown = findViewById<TextView>(R.id.textViewTown)
        val btnWeather = findViewById<Button>(R.id.btnTownChoice)
        btnWeather.setOnClickListener() {
            Intent(this, TownChoiseActivity::class.java).also { startActivity(it) }
        }
    }
}