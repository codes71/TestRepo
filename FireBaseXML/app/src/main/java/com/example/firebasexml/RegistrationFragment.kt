package com.example.firebasexml

import LoginFrag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegistrationFragment : Fragment() {
    private lateinit var database : DatabaseReference
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        val nameET = view.findViewById<EditText>(R.id.first_name_et)
        val emailET = view.findViewById<EditText>(R.id.email_et)
        val passwordET = view.findViewById<EditText>(R.id.password_et)
        val regBtnET = view.findViewById<Button>(R.id.reg_submit_btn)
        val loginBtnET = view.findViewById<Button>(R.id.login_button)

        database = Firebase.database("https://androidxmlrealtimedb-default-rtdb.asia-southeast1.firebasedatabase.app").reference
        regBtnET.setOnClickListener {
            Log.d("RegAct", "Clicked")
            val name = nameET.text.toString().trim()
            val email = emailET.text.toString().trim()
            val password = passwordET.text.toString().trim()
            val user = mapOf(
                "name" to name,
                "email" to email,
                "password" to password,
            )
            Log.d("User",database.toString())
            database.child("users").push().setValue(user).addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("RegAct", "Database write successful")
                    Toast.makeText(requireContext(), "Reg Success", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, LoginFrag())
                        .commit()
                } else {
                    Toast.makeText(requireContext(), "Reg Unsuccessful", Toast.LENGTH_SHORT).show()
                }
            }
        }
        loginBtnET.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFrag())
                .commit()
        }
        return view
    }
}