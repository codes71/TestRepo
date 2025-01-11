import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.firebasexml.R
import com.example.firebasexml.RegistrationFragment
import com.example.firebasexml.WelcomeFragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginFrag : Fragment() {
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val emailET = view.findViewById<EditText>(R.id.loginEmail)
        val passwordET = view.findViewById<EditText>(R.id.loginPassword)
        val loginBtnET = view.findViewById<Button>(R.id.button_Login)
        val registerBtn = view.findViewById<TextView>(R.id.button_signup)
        database = Firebase.database("https://androidxmlrealtimedb-default-rtdb.asia-southeast1.firebasedatabase.app").reference
        loginBtnET.setOnClickListener {
            val email = emailET.text.toString().trim()
            val password = passwordET.text.toString().trim()

            database.child("users").get().addOnSuccessListener { task ->
                var isValid = false
                for (users in task.children) {
                    val user = users.value as Map<*, *>
                    if (user["email"] == email && user["password"] == password) {
                        isValid = true
                        break
                    }
                }
                if (isValid) {
                    Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, WelcomeFragment())
                        .commit()
                } else {
                    Toast.makeText(requireContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show()
                }
            }
        }

        registerBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegistrationFragment())
                .commit()
        }
        return view
    }
}
