package com.singlepointsol.firebaseauthenticationdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SigninActivity : AppCompatActivity(), View.OnClickListener {
    // Initialization
    lateinit var unameEt: EditText
    lateinit var passwordEt: EditText
    lateinit var signinBtn: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)

        // Load views into activity
        unameEt = findViewById(R.id.username_et)
        passwordEt = findViewById(R.id.password_et)
        signinBtn = findViewById(R.id.signin_button)

        // Initialize FirebaseAuth
        auth = Firebase.auth

        // Set listeners
        signinBtn.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val username = unameEt.text.toString().trim()
        val password = passwordEt.text.toString().trim()

        // Check if fields are empty
        if (username.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(username, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Sign-in successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Optional: Prevent returning to SigninActivity
                } else {
                    // Show detailed error message
                    Toast.makeText(this, "Unable to sign in", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            // Prompt user to fill all fields
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_LONG).show()
        }
    }
}
