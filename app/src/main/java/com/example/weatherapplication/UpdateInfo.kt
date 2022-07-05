package com.example.weatherapplication

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

import androidx.lifecycle.lifecycleScope
import com.example.watherapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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