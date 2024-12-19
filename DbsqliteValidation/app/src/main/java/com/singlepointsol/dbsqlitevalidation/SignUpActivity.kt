package com.singlepointsol.dbsqlitevalidation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.singlepointsol.sqlitedatabase.DBHelper
import com.singlepointsol.sqlitedatabase.Employee
import com.singlepointsol.sqlitedatabase.EmployeesDetails

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var uname:EditText
    lateinit var pwd:EditText
    lateinit var email:EditText
    lateinit var loadBtn:Button
    lateinit var signupBtn:Button
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        //load views into activity
        uname=findViewById(R.id.uname_editText)
        pwd=findViewById(R.id.pswd_editText)
        email=findViewById(R.id.email_editText)
        loadBtn=findViewById(R.id.load_button)
        signupBtn=findViewById(R.id.signupBtn)
        loadBtn.setOnClickListener(this)
        signupBtn.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0!=null){
            when(p0.id){
                R.id.load_button->{
                    if (uname.text.isNotEmpty() && email.text.isNotEmpty() && pwd.text.isNotEmpty()){
                        val employee= Employee(uname.text.toString(),email.text.toString(),pwd.text.toString())

                        val result=dbHelper.addEmployee(employee)
                        if (result >=-1){
                            Toast.makeText(applicationContext,"Data Inserted!", Toast.LENGTH_LONG).show()
                            uname.text.clear()
                            email.text.clear()
                            pwd.text.clear()
                        }
                        else{
                            Toast.makeText(applicationContext,"name or email or phone cannot be blank",
                                Toast.LENGTH_LONG).show()
                        }
                    }

                }
                R.id.signupBtn->{
                    val inte=Intent(this,WelcomeActivity::class.java)
                    startActivity(inte)
                }
            }
        }

    }
}