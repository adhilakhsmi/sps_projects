package com.singlepointsol.valaditaionpractice

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
    //init
    lateinit var uname:EditText
    lateinit var password:EditText
    lateinit var signup: Button
    lateinit var signin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        uname=findViewById(R.id.uname_et)
        password=findViewById(R.id.password_et)
        signup=findViewById(R.id.signup_btn)
        signin=findViewById(R.id.signin_btn)
        //set listener
        signup.setOnClickListener(this)
        signin.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if(v!=null){
            when(v.id){
                R.id.signup_btn->{
                    val signupintent= Intent(this,SignupActivity::class.java)
                    startActivity(signupintent)

                }
                R.id.signin_btn->{
                     val signinintent=Intent(this,SignActivity::class.java)
                    startActivity(signinintent
                    )
                }
            }
        }
    }
}