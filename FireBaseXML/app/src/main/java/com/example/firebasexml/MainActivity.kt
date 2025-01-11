package com.example.firebasexml

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            val loginFrag = RegistrationFragment()
            supportFragmentManager.beginTransaction() .replace(R.id.fragmentContainer, loginFrag) .commit()
        }

    }
}