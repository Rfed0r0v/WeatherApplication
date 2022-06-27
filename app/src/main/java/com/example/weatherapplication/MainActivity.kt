package com.example.weatherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.watherapplication.R

var Town = "Лондон"
lateinit var textViewTemp: TextView
lateinit var textViewWind: TextView
lateinit var textViewTown: TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var temp = "22"
        var wind = "2"

        textViewTemp = findViewById<TextView>(R.id.textViewTemp)
        textViewWind = findViewById<TextView>(R.id.textViewWind)
        textViewTown = findViewById<TextView>(R.id.textViewTown)
        val btnWeather = findViewById<Button>(R.id.btnTownChoice)

        if (Town == "Лондон") {
            temp = "22"
            wind = "1"
        }
        if (Town == "Париж") {
            temp = "26"
            wind = "5"
        }
        textViewTown.text = "Город: $Town"
        textViewTemp.text = "Температура: $temp C"
        textViewWind.text = "Ветер: $wind м/с"
        btnWeather.setOnClickListener {
            Intent(this, TownChoiseActivity::class.java).also { startActivity(it) }
        }
    }
}