package com.example.weatherapplication

import android.widget.Spinner
import com.example.watherapplication.R

class UpdateInfo {
    fun updateInfo() {

//            val spinner = spinnerView
//                spinner.setSelection(radioChecked)

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
        textViewTownAct2.text = "Город: $Town"
        textViewTempAct2.text = "Температура: $temp C"
        textViewWindAct2.text = "Ветер: $wind м/с"
    }
}