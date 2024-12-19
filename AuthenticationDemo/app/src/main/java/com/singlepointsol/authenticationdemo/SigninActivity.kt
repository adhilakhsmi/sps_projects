package com.singlepointsol.firebaseauthenticationdemo

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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.singlepointsol.authenticationdemo.MainActivity
import com.singlepointsol.authenticationdemo.R

class SigninActivity : AppCompatActivity(), View.OnClickListener {
    //initialization
    lateinit var unameEt:EditText
    lateinit var passwordEt:EditText
    lateinit var signinBtn:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        // load views into activity
        unameEt=findViewById(R.id.username_et)
        passwordEt=findViewById(R.id.password_et)
        signinBtn=findViewById(R.id.signin_button)
        auth=Firebase.auth
        //set listeners
        signinBtn.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val username=unameEt.text.toString()
        val password=passwordEt.text.toString()
        auth.signInWithEmailAndPassword(username,password).addOnCompleteListener {
            if(it.isSuccessful){
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"unable to signin",Toast.LENGTH_LONG).show()
            }
        }


    }
}