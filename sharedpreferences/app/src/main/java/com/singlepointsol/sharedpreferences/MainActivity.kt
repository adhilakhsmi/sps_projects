package com.singlepointsol.sharedpreferences

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
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var name_et: EditText
    lateinit var password_et: EditText
    lateinit var loadBtn: Button
    lateinit var saveBtn: Button
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views into activity
        name_et = findViewById(R.id.name_editText)
        password_et = findViewById(R.id.password_editText)
        loadBtn = findViewById(R.id.load_button)
        saveBtn = findViewById(R.id.save_button)
        //set listeners to butons
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
        //create dharepref file
       sharedPrefs= getSharedPreferences("singlepointprefs", MODE_PRIVATE)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.save_button -> {
                    val editor:SharedPreferences.Editor=sharedPrefs.edit()
                    editor.putString("nameKey",name_et.text.toString())
                    editor.putString("passwordKey",password_et.text.toString())
                    editor.apply()
                    name_et.text.clear()
                    password_et.text.clear()

                }

                R.id.load_button -> {
                    if(sharedPrefs.contains("nameKey")){
                        val name:String=sharedPrefs.getString("nameKey",null).toString()
                        name_et.setText(name)
                    }
                    else{


                        Toast.makeText(this,"Empty name preference",Toast.LENGTH_LONG).show()
                    }
                    if(sharedPrefs.contains("passwordKey")){
                        val password:String=sharedPrefs.getString("passwordKey",null).toString()
                        password_et.setText(password)
                    }
                    else{
                        Toast.makeText(this,"Empty Password preference",Toast.LENGTH_LONG).show()

                    }

                }

            }
        }
    }
}