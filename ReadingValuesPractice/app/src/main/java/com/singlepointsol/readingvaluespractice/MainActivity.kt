package com.singlepointsol.readingvaluespractice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity: AppCompatActivity() {
    //late intialization
    lateinit var name_edit_txt:EditText
    lateinit var phone_edit_txt:EditText
    lateinit var email_edit_txt:EditText
    lateinit var designation_edit_txt:EditText
    lateinit var address_edit_txt:EditText
    lateinit var dob_edit_txt:EditText
    lateinit var submit_btn:Button
    lateinit var name_text_view:TextView
    lateinit var phone_text_view:TextView
    lateinit var email_text_view:TextView
    lateinit var designation_text_view:TextView
    lateinit var address_text_view:TextView
    lateinit var dob_text_view:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        name_edit_txt=findViewById(R.id.name_et)
        phone_edit_txt=findViewById(R.id.phone_et)
        email_edit_txt=findViewById(R.id.email_et)
        designation_edit_txt=findViewById(R.id.designation_et)
        address_edit_txt=findViewById(R.id.address_et)
        dob_edit_txt=findViewById(R.id.dob_et)
        submit_btn=findViewById(R.id.submit_btn)
        name_text_view=findViewById(R.id.name_tv)
        phone_text_view=findViewById(R.id.phone_tv)
        email_text_view=findViewById(R.id.email_tv)
        designation_text_view=findViewById(R.id.designation_tv)
        address_text_view=findViewById(R.id.address_tv)
        dob_text_view=findViewById(R.id.dob_tv)
        //load listener
        submit_btn.setOnClickListener(View.OnClickListener {
            val name_edit_txt:String=name_edit_txt.text.toString()
            name_text_view.text=name_edit_txt
            val phone_edit_txt:String=phone_edit_txt.text.toString()
            phone_text_view.text=phone_edit_txt
            val email_edit_txt:String=email_edit_txt.text.toString()
            email_text_view.text=email_edit_txt
            val designation_edit_txt:String=designation_edit_txt.text.toString()
            designation_text_view.text=designation_edit_txt
            val address_edit_txt:String=address_edit_txt.text.toString()
            address_text_view.text=address_edit_txt
            val  dob_edit_txt:String=dob_edit_txt.text.toString()
            dob_text_view.text=dob_edit_txt



        })




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}