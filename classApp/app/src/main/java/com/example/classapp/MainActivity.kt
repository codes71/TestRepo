package com.example.classapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btn:Button
    private lateinit var edit1: EditText
    private lateinit var edit2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.bt1)
        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)

        btn.setOnClickListener{
            val name = "Welcome ${edit1.text.toString().trim()} With ${edit2.text.toString().trim()}"
            val intent  = Intent(this@MainActivity,Dashboard::class.java).apply {
                putExtra("data",name)
            }
            startActivity(intent)
        }
    }
}