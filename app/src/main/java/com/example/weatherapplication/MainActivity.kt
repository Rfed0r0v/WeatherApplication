package com.example.weatherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.watherapplication.R

lateinit var radioButtonLondon:RadioButton
lateinit var radioButtonParis:RadioButton
var Temp = "22"
var Wind = "2"
var Town = "Лондон"
lateinit var textViewTemp:TextView
lateinit var textViewWind:TextView
lateinit var textViewTown:TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewTemp = findViewById<TextView>(R.id.textViewTemp)
        textViewWind = findViewById<TextView>(R.id.textViewWind)
        textViewTown = findViewById<TextView>(R.id.textViewTown)
        val btnWeather = findViewById<Button>(R.id.btnTownChoice)

        //radioButtonLondon = findViewById<RadioButton>(R.id.radioButtonLondon)
        //radioButtonParis = findViewById<RadioButton>(R.id.radioButtonParis)

        textViewTown.text = "Город: $Town"
        textViewTemp.text = "Температура: $Temp C"
        textViewWind.text = "Ветер: $Wind м/с"
        btnWeather.setOnClickListener {
            Intent(this, TownChoiseActivity::class.java).also { startActivity(it) }
        }
    }



}