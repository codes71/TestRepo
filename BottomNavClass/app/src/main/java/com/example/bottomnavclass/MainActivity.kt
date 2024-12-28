package com.example.bottomnavclass

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavigationView.setOnNavigationItemSelectedListener{ item ->

            val fragment : Fragment = when(item.itemId){
                R.id.homeIcon_nav -> HomeFragment()
                R.id.callIcon_nav -> CallFragment()
                R.id.photoIcon_nav -> PhotoFragment()
                R.id.messageIcon_nav ->MessageFragment()
                R.id.profileIcon_nav -> ProfileFragment()
                else -> HomeFragment()
            }
            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(homeFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_graph, homeFragment)
            .commit()
    }
}