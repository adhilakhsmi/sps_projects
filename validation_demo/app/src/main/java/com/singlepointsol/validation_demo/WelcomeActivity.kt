package com.singlepointsol.validation_demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {
    //late
    lateinit var home:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        //views
        home=findViewById(R.id.home_button)
        //pass key
        val myName:String=intent.getStringExtra("name").toString()

        //load listener
        home.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if(v!=null){
            when(v.id){
                R.id.home_button->{
                    val homeintent= Intent(this,MainActivity::class.java)
                    startActivity(homeintent)

                }
            }
        }
    }
}