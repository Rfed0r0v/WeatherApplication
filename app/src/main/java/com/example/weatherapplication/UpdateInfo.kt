package com.example.weatherapplication

import android.widget.RadioButton
import android.widget.Spinner

class UpdateInfo {
    fun updateInfo(pos: Int, spin: Spinner, rad: RadioButton) {

        TownChoiseActivity().setWeather(Town)// придумаем погоду

// установим spinner и radiobutton в одинаковые положения
        spin.setSelection(pos,true)
        rad.isChecked = true

// обновим погоду на обеих активити
        textViewTown.text = "Город: $Town"
        textViewTemp.text = "Температура: $temp C"
        textViewWind.text = "Ветер: $wind м/с"
        textViewTownAct2.text = "Город: $Town"
        textViewTempAct2.text = "Температура: $temp C"
        textViewWindAct2.text = "Ветер: $wind м/с"
    }
}