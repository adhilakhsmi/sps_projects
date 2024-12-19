package com.singlepointsol.validation_demo

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

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var name: EditText
    lateinit var passwd: EditText
    lateinit var signUp: Button
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        name = findViewById(R.id.name_et)
        passwd = findViewById(R.id.pasword_et)
        signUp = findViewById(R.id.signup_btn)

        // Initialize DBHelper
        dbHelper = DBHelper(this)

        // Set listeners
        signUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null && v.id == R.id.signup_btn) {
            val username = name.text.toString().trim()
            val password = passwd.text.toString().trim()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val result = dbHelper.insertUser(username, password)
                if (result != -1L) {
                    Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
                    name.text.clear()
                    passwd.text.clear()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Error during sign-up", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
