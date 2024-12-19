package com.singlepointsol.dbsqlitevalidation

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

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var signinBtn: Button
    lateinit var signupBtn: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Load views into activity
        userName = findViewById(R.id.nameEditText)
        password = findViewById(R.id.passwordeditText)
        signinBtn = findViewById(R.id.signin_button)
        signupBtn = findViewById(R.id.signup_button)



        // Set listeners
        signinBtn.setOnClickListener(this)
        signupBtn.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.signin_button -> {
                    handleSignIn()
                }

                R.id.signup_button ->{

                 handleSignUp()
                    }
            }
        }
    }

    private fun handleSignIn() {
        val username = userName.text.toString().trim()
        val password = this.password.text.toString().trim()

    }
    private fun handleSignUp() {
        val username = userName.text.toString().trim()
        val password = this.password.text.toString().trim()

        if (username.isNotEmpty() && password.isNotEmpty()) {

                Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
                val signupIntent = Intent(this, SignUpActivity::class.java)
                startActivity(signupIntent)
            } else {
                Toast.makeText(this, "Error during sign-up", Toast.LENGTH_SHORT).show()
            }
        }
    }

