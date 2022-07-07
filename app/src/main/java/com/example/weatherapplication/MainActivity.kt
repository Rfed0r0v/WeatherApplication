package com.example.weatherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.watherapplication.R



lateinit var textViewTemp: TextView
lateinit var textViewWind: TextView
lateinit var textViewTown: TextView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewTemp = findViewById<TextView>(R.id.textViewTemp)
        textViewWind = findViewById<TextView>(R.id.textViewWind)
        textViewTown = findViewById<TextView>(R.id.textViewTown)
        val btnWeather = findViewById<Button>(R.id.btnTownChoice)

        if (Town == COUNTRIES[0]) {
            temp = "22"
            wind = "1"
        }
        if (Town == COUNTRIES[1]) {
            temp = "26"
            wind = "5"
        }

        if (Town == COUNTRIES[2]) {
            temp = "33"
            wind = "2"
        }
        textViewTown.text = "Город: $Town"
        textViewTemp.text = "Температура: $temp C"
        textViewWind.text = "Ветер: $wind м/с"
        btnWeather.setOnClickListener {
            Intent(this, TownChoiseActivity::class.java).also { startActivity(it) }
        }
    }
}