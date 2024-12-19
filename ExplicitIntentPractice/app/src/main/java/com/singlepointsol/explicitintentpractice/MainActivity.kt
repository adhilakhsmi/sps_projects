package com.singlepointsol.explicitintentpractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //lateinitialization
    lateinit var name_et:EditText
    lateinit var phone_et:EditText
    lateinit var designation_et:EditText
    lateinit var submitBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        name_et=findViewById(R.id.name_edit_text)
        phone_et=findViewById(R.id.phone_edit_text)
        designation_et=findViewById(R.id.designation_edit_text)
        submitBtn=findViewById(R.id.submit_button)
        //set listener
        submitBtn.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val intent= Intent(this,AndroidActivity::class.java)
        intent.putExtra("name",name_et.text.toString())
        intent.putExtra("phone",phone_et.text.toString())
        intent.putExtra("designation",designation_et.text.toString())
        startActivity(intent)

    }
}