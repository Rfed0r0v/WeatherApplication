package com.example.weatherapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.watherapplication.R

lateinit var textViewTempAct2: TextView
lateinit var textViewWindAct2: TextView
lateinit var textViewTownAct2: TextView

lateinit var radio: RadioButton
lateinit var spinner: Spinner
var globalPosition: Int = 0
val COUNTRIES = arrayOf("Лондон", "Париж", "Катманду")

var temp = "22"
var wind = "2"
var Town = COUNTRIES[0]
val radioButtonsArray =
    arrayOf(R.id.radioButtonLondon, R.id.radioButtonParis, R.id.radioButtonKatmandu)

class TownChoiseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town_choise)
        val radGrp = findViewById<RadioGroup>(R.id.radioGroup)
        radio = findViewById(R.id.radioButtonLondon)

        textViewTempAct2 = findViewById<TextView>(R.id.textViewTempAct2)
        textViewWindAct2 = findViewById<TextView>(R.id.textViewWindAct2)
        textViewTownAct2 = findViewById<TextView>(R.id.textViewTownAct2)

        setWeather(Town)

        spinner = findViewById(R.id.spinner)
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, COUNTRIES)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                globalPosition = position
                Town = parent.getItemAtPosition(position).toString()
                radio = findViewById(radioButtonsArray[position])
                UpdateInfo().updateInfo(position, spinner, radio)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        val butBack2Main = findViewById<Button>(R.id.butBack2Main)
        butBack2Main.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }

        radGrp.setOnCheckedChangeListener { group, checkedId ->
            radio = findViewById(checkedId)
            Town = radio.text.toString()
            when (Town) {
                COUNTRIES[0] -> globalPosition = 0
                COUNTRIES[1] -> globalPosition = 1
                COUNTRIES[2] -> globalPosition = 2
                else -> throw  Exception("Программа пытается допустить недопустимое, выполнить невыполнимое")
            }
            UpdateInfo().updateInfo(globalPosition, spinner, radio)
        }
    }

    fun setWeather(Town: String) { // придумаем погоду
        when (Town) {
            COUNTRIES[0] -> {
                temp = "22"
                wind = "1"
            }
            COUNTRIES[1] -> {
                temp = "26"
                wind = "5"
            }
            COUNTRIES[2] -> {
                temp = "33"
                wind = "3"
            }
            else -> throw  Exception("Программа пытается допустить недопустимое, выполнить невыполнимое")
        }
    }
}
