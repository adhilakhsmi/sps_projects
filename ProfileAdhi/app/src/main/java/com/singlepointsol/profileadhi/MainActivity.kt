package com.singlepointsol.profileadhi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name_et: EditText
    lateinit var phone_et: EditText
    lateinit var email_et: EditText
    lateinit var designation_et: EditText
    lateinit var submit_btn: Button
    lateinit var name_tv: TextView
    lateinit var phone_tv: TextView
    lateinit var email_tv: TextView
    lateinit var designation_tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views after setContentView
        name_et = findViewById(R.id.editTextName)
        phone_et = findViewById(R.id.editTextPhone)
        email_et = findViewById(R.id.editTextMail)
        designation_et = findViewById(R.id.editTextDesignation)
        submit_btn = findViewById(R.id.submitButton) // Use correct ID for the Button
        name_tv = findViewById(R.id.textViewName)
        phone_tv = findViewById(R.id.textViewPhone) // Use correct ID for phone_tv
        email_tv = findViewById(R.id.textViewMail)
        designation_tv = findViewById(R.id.textViewDesignation) // Fix the typo in the ID

        // Set listener
        submit_btn.setOnClickListener {
            val nameText: String = name_et.text.toString()
            val phoneText: String = phone_et.text.toString()
            val emailText: String = email_et.text.toString()
            val designationText: String = designation_et.text.toString()

            name_tv.text = nameText
            phone_tv.text = phoneText
            email_tv.text = emailText
            designation_tv.text = designationText
        }

        // Optional: Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
