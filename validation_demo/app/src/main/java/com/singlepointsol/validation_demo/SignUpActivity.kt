package com.singlepointsol.validation_demo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sign

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    //late init
    lateinit var name:EditText
    lateinit var passwd:EditText
    lateinit var sign_up:Button
    lateinit var sharedPref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        //load views
        name=findViewById(R.id.name_et)
        passwd=findViewById(R.id.pasword_et)
        sign_up=findViewById(R.id.signup_btn)
        //set listeners
        sign_up.setOnClickListener(this)
        //create preference file
        sharedPref= getSharedPreferences("loginprefs", MODE_PRIVATE)
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
                    /*if(name.text.toString().equals("singlepoint") && passwd.text.toString().equals("Android")){
                        val welcomeinte=Intent(this,WelcomeActivity::class.java)
                        startActivity(welcomeinte)
                    }
                    val welcomeintent=Intent(this,WelcomeActivity::class.java)
                    startActivity(welcomeintent)*/
                    val editor:SharedPreferences.Editor=sharedPref.edit()
                      editor.putString("nameKey",name.text.toString()) 
                              editor.putString("passwordKey",passwd.text.toString())
                    editor.apply()
                    name.text.clear()
                    passwd.text.clear()
                }

            }
        }
    }
}