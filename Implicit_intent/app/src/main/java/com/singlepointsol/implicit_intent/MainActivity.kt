package com.singlepointsol.implicit_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var call:Button
    lateinit var dial:Button
    lateinit var browse:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        call=findViewById(R.id.call_button)
        dial=findViewById(R.id.dial_button)
        browse=findViewById(R.id.browse_button)
        //set listeners
        call.setOnClickListener(this)
        dial.setOnClickListener(this)
        browse.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if(view!=null){
            when(view.id){
                R.id.call_button-> {

                    val callintent = Intent(Intent.ACTION_CALL, Uri.parse("tel:8317597442"))
                    startActivity(callintent)
                }
                 R.id.dial_button->{
                     val dialintent=Intent(Intent.ACTION_DIAL,Uri.parse("tel:+918317597442"))
                        startActivity(dialintent)
                    }
                 R.id.browse_button->{
                     val browseintent=Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/components/intents-common"))
                     startActivity(browseintent)

                    }


                }
            }
        }
    }
