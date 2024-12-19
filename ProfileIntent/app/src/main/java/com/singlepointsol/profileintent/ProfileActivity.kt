package com.singlepointsol.profileintent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity(),OnClickListener{
//lateinit
    lateinit var Nametv:TextView
    lateinit var MobileTv:TextView
    lateinit var EmailTv:TextView
    lateinit var DesignationTv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        //load views
        Nametv=findViewById(R.id.NameTextView)
        MobileTv=findViewById(R.id.MobileTextView)
        EmailTv=findViewById(R.id.EmailTextView)
        DesignationTv=findViewById(R.id.DesignationTextView)
        //pass data

        val myValue:String=intent.getStringExtra("name").toString()
        Nametv.text=myValue

        val myValue1:String=intent.getStringExtra("mobile").toString()
        MobileTv.text=myValue1

        val myValue2:String=intent.getStringExtra("email").toString()
        EmailTv.text=myValue2

        val myValue3:String=intent.getStringExtra("designation").toString()
        DesignationTv.text=myValue3





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