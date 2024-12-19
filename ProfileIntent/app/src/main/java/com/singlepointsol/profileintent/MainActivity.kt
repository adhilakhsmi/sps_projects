package com.singlepointsol.profileintent

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
    ///late inint
    lateinit var NameEt:EditText
    lateinit var MobileEt:EditText
    lateinit var EmailEt:EditText
    lateinit var DesignationEt:EditText
    lateinit var submitBtn:Button

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            //add views
            NameEt=findViewById(R.id.NamEditText)
            MobileEt=findViewById(R.id.MobileEditText)
            EmailEt=findViewById(R.id.MailEditText)
            DesignationEt=findViewById(R.id.DesignationEditText)
            submitBtn=findViewById(R.id.SubmitBtn)
            //load listeners

            submitBtn.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?){
        val intent= Intent(this,ProfileActivity::class.java)
        //set key to pass the edittext to textView using putExtra
        intent.putExtra("name",NameEt.text.toString())
        intent.putExtra("mobile",MobileEt.text.toString())
        intent.putExtra("email",EmailEt.text.toString())
        intent.putExtra("designation",DesignationEt.text.toString())
        startActivity(intent)





    }
}