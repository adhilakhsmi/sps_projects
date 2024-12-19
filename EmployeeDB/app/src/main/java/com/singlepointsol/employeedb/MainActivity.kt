package com.singlepointsol.employeedb

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //initialzation
    lateinit var idEt:EditText
    lateinit var nameEt:EditText
    lateinit var emailEt:EditText
    lateinit var phoneEt:EditText
    lateinit var designationEt:EditText
    lateinit var loadBtn:Button
    lateinit var saveBtn:Button
    lateinit var database: FirebaseDatabase
    lateinit var databaseReference:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views into activity
        idEt=findViewById(R.id.id_editText)
        nameEt=findViewById(R.id.name_editText)
        emailEt=findViewById(R.id.email_editText)
        phoneEt=findViewById(R.id.phone_editText)
        designationEt=findViewById(R.id.designation_editText)
        loadBtn=findViewById(R.id.load_button)
        saveBtn=findViewById(R.id.save_button)
        //set listeners
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
        database= Firebase.database
        databaseReference=database.reference.child("Employees")


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v!=null){
            when(v.id){
                R.id.load_button->{
                    val intent= Intent(this,EmployeeDetails::class.java)
                    startActivity(intent)

                }
                R.id.save_button->{
                    if(nameEt.text.toString().isNotEmpty()&&idEt.text.toString().isNotEmpty()&&emailEt.text.toString().isNotEmpty()&&phoneEt.text.toList().isNotEmpty()&&designationEt.text.toString().isNotEmpty()){
                        val employee=Employee(idEt.text.toString(),nameEt.text.toString(),phoneEt.text.toString(),emailEt.text.toString(),designationEt.text.toString())
                        databaseReference.push().setValue(employee)
                        Toast.makeText(applicationContext,"Data Inserted",Toast.LENGTH_LONG).show()
                        nameEt.text.clear()
                        emailEt.text.clear()
                        phoneEt.text.clear()
                        idEt.text.clear()
                        designationEt.text.clear()

                    }

                }
            }
        }
    }
}