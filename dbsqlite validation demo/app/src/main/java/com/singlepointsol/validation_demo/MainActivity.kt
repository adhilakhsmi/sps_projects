
package com.singlepointsol.validation_demo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var signin: Button
    lateinit var signup: Button
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        username = findViewById(R.id.uname_et)
        password = findViewById(R.id.password_et)
        signin = findViewById(R.id.signin_button)
        signup = findViewById(R.id.sugnup_button)

        // Initialize DBHelper
        dbHelper = DBHelper(this)
        // Set listeners
        signin.setOnClickListener(this)
        signup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signin_button -> {
                val uname = username.text.toString().trim()
                val pwd = password.text.toString().trim()

                if (uname.isNotEmpty() && pwd.isNotEmpty()) {
                    if (dbHelper.isUserValid(uname, pwd)) {
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, WelcomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.sugnup_button -> {
                val signupinte = Intent(this, SignUpActivity::class.java)
                startActivity(signupinte)

            }
        }
    }
}
