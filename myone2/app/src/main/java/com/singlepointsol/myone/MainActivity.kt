package com.singlepointsol.myone

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),OnClickListener {
    lateinit var mrng:Button
    lateinit var aftrnn:Button
    lateinit var eveng:Button
    lateinit var parentLayout:ConstraintLayout
    lateinit var displayText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        //add views
        mrng=findViewById(R.id.gmrngbtn)
        aftrnn=findViewById(R.id.aftrnnbtn)
        eveng=findViewById(R.id.evngbtn)
        parentLayout=findViewById(R.id.main)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            //add listeners
       mrng.setOnClickListener(this)
        aftrnn.setOnClickListener(this)
        eveng.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
       if(v!=null){
           when(v.id){
               R.id.gmrngbtn->{
                   parentLayout.setBackgroundResource(R.drawable.mrng1)


               }
               R.id.aftrnnbtn->{
                   parentLayout.setBackgroundResource(R.drawable.aftrnn3)
           }
               R.id.evngbtn->{
                   parentLayout.setBackgroundResource(R.drawable.images)
               }               }
       }
    }
}