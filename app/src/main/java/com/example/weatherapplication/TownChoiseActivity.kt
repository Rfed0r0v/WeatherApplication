package com.example.weatherapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.watherapplication.R

class TownChoiseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town_choise)

//        val radioButtonLondon = findViewById<RadioButton>(R.id.radioButtonLondon)
//        val radioButtonParis = findViewById<RadioButton>(R.id.radioButtonParis)
        val radGrp = findViewById<RadioGroup>(R.id.radioGroup)

        val butBack2Main = findViewById<Button>(R.id.butBack2Main)
        butBack2Main.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }


        radGrp.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Town = radio.text.toString()
            })
    }
}
