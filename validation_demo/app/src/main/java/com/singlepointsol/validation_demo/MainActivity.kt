package com.singlepointsol.validation_demo

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sign

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var username: EditText
    lateinit var passwordd: EditText
    lateinit var signin: Button
    lateinit var signup: Button
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        username = findViewById(R.id.uname_et)
        passwordd = findViewById(R.id.password_et)
        signin = findViewById(R.id.signin_button)
        signup = findViewById(R.id.sugnup_button)
        //set listeners
        signin.setOnClickListener(this)
        signup.setOnClickListener(this)
        //use signup file(loginprefs)in login for  comparison
        sharedPrefs = getSharedPreferences("loginprefs", MODE_PRIVATE)
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
                    if (username.text.toString().isEmpty() && passwordd.text.toString().isEmpty()) {
                        val toast =
                            Toast.makeText(this, "Enter username and password", Toast.LENGTH_SHORT)

                        // Customize the Toast
                        val toastView = toast.view // Get the default view of the Toast
                        // Change the text color to red
                        val toastMessage =
                            toastView?.findViewById<TextView>(android.R.id.message) // Get the TextView
                        toastMessage?.setTextColor(Color.RED)
                        toastView?.setBackgroundColor(Color.WHITE)


                        // Show the Toast
                        toast.show()
                    }

                    if (sharedPrefs.contains("nameKey") && sharedPrefs.contains("passwordKey")) {

                        val userName: String? = sharedPrefs.getString("nameKey", null)
                        val password: String? = sharedPrefs.getString("passwordKey", null)


                        if (username.text.toString() == userName && passwordd.text.toString() == password) {
                            val welcomeinte = Intent(this, WelcomeActivity::class.java)
                            startActivity(welcomeinte)

                        } else {
                            val signupactivity = AlertdialogFragment()
                            signupactivity.show(supportFragmentManager, "sigup")
                            /*val alertfragment=AlertdialogFragment()
                             alertfragment.show(supportFragmentManager,"alert")*/
                            /*
                            val toast = Toast.makeText(this, "Enter valid username and password", Toast.LENGTH_SHORT)
                            // Customize the Toast
                            val toastView = toast.view // Get the default view of the Toast
                            // Change the text color to red
                            val toastMessage = toastView?.findViewById<TextView>(android.R.id.message) // Get the TextView
                            toastMessage?.setTextColor(Color.RED)
                            toastView?.setBackgroundColor(Color.WHITE)
                            // Show the Toast
                            toast.show()*/
                        }

                    }


                }

                R.id.signup_btn -> {
                    if (username.text.toString().equals("adhi") && passwordd.text.toString()
                            .equals("1234")
                    ) {
                        val signupintent = Intent(this, WelcomeActivity::class.java)
                        startActivity(signupintent)

                    } else {
                        Toast.makeText(this, "enter username and password", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }
}
