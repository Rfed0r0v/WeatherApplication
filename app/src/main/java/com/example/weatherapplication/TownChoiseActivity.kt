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

var temp = "22"
var wind = "2"

var Town = COUNTRIES[0]


class TownChoiseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town_choise)
        val radGrp = findViewById<RadioGroup>(R.id.radioGroup)

        textViewTempAct2 = findViewById<TextView>(R.id.textViewTempAct2)
        textViewWindAct2 = findViewById<TextView>(R.id.textViewWindAct2)
        textViewTownAct2 = findViewById<TextView>(R.id.textViewTownAct2)
//        val btnWeather = findViewById<Button>(R.id.btnTownChoice)

        if (Town == COUNTRIES[0]) {
            temp = "22"
            wind = "1"
        }
        if (Town == COUNTRIES[1]) {
            temp = "26"
            wind = "5"
        }

        if (Town == COUNTRIES[2]) {
            temp = "23"
            wind = "3"
        }
        textViewTown.text = "Город: $Town"
        textViewTemp.text = "Температура: $temp C"
        textViewWind.text = "Ветер: $wind м/с"

        val spinner = findViewById<Spinner>(R.id.spinner)
//        spinnerView = spinner
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
                Town = parent.getItemAtPosition(position).toString()
//                spinnerChecked = position
                UpdateInfo().updateInfo()
                //Town = countries[position]
                //val intent = Intent(this@TownChoiseActivity, MainActivity::class.java)
                //startActivity(intent)

//                    Intent(this, MainActivity::class.java).also { startActivity(this,MainActivity) }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        val butBack2Main = findViewById<Button>(R.id.butBack2Main)
        butBack2Main.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }

        radGrp.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
//                radioChecked = checkedId

                val radio: RadioButton = findViewById(checkedId)
//                radioView = radio
                Town = radio.text.toString()
                UpdateInfo().updateInfo()

            })
    }
}
