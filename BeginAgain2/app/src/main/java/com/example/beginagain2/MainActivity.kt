package com.example.beginagain2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val myButton = findViewById<Button>(R.id.myButton)
        myButton.text = "Click me to change the text"
    }
    fun changeButtonText(view: android.view.View) {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Text Changed on Click"
    }
}