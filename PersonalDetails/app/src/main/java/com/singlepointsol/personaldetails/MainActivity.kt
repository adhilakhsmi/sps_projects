package com.singlepointsol.personaldetails

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var phone: EditText
    lateinit var emailadd:EditText
    lateinit var designation: EditText
    lateinit var submitBtn:Button
    lateinit var nameTxt:TextView
    lateinit var phoneTxt:TextView
    lateinit var emailTxt:TextView
    lateinit var designTxt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loads views into activity
        name=findViewById(R.id.nameEdit)
        phone=findViewById(R.id.phoneEdit)
        emailadd=findViewById(R.id.emailEdit)
        designation=findViewById(R.id.desiEdit)
        submitBtn=findViewById(R.id.submitEdit)
        nameTxt=findViewById(R.id.name_txt)
        phoneTxt=findViewById(R.id.phone_txt)
        emailTxt=findViewById(R.id.email_txt)
        designTxt=findViewById(R.id.desi_txt)

        submitBtn.setOnClickListener(View.OnClickListener {
            val name:String= name.text.toString()
            nameTxt.text=name
            val phone:String=phone.text.toString()
            phoneTxt.text=phone
            val emailadd:String=emailadd.text.toString()
            emailTxt.text=emailadd
            val designation:String=designation.text.toString()
            designTxt.text=designation




        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}