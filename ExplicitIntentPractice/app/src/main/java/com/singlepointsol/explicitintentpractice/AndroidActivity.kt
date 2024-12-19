package com.singlepointsol.explicitintentpractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AndroidActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var name_tv:TextView
    lateinit var phone_tv:TextView
    lateinit var designation_tv:TextView
    lateinit var homeBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_android)
        //load views
        name_tv=findViewById(R.id.name_textview)
        phone_tv=findViewById(R.id.phone_textview)
        designation_tv=findViewById(R.id.designation_textview)
        homeBtn=findViewById(R.id.home_button)
        //load keys
       val myKey1:String=intent.getStringExtra("name").toString()
        name_tv.text=myKey1
        val myKey2:String=intent.getStringExtra("phone").toString()
        phone_tv.text=myKey2
        val myKey3:String=intent.getStringExtra("designation").toString()
        designation_tv.text=myKey3
        //set listener
        homeBtn.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}