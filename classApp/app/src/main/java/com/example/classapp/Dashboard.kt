package com.example.classapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader

class Dashboard : AppCompatActivity() {
    private lateinit var txt : EditText
    private lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        txt = findViewById(R.id.dataText)
        btn = findViewById(R.id.button_show)

        btn.setOnClickListener{
            val data = intent.getStringExtra("data")
            txt.setText(data)
        }
    }
}