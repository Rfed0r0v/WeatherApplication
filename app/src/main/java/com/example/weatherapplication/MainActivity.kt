package com.example.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.watherapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewID = findViewById<TextView>(R.id.textViewId)
        textViewID.text = "Text2"
    }
}