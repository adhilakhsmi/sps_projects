package com.singlepointsol.e_commercedb

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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //initialization
    lateinit var productIdEt:EditText
    lateinit var nameEt:EditText
    lateinit var descriptionEt:EditText
    lateinit var priceEt:EditText
    lateinit var categoryEt:EditText
    lateinit var discountEt:EditText
    lateinit var brandEt:EditText
    lateinit var loadBtn:Button
    lateinit var saveBtn:Button
    lateinit var database: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views into  activity
        productIdEt=findViewById(R.id.product_id_editText)
        nameEt=findViewById(R.id.name_editText)
        descriptionEt=findViewById(R.id.description_editText)
        priceEt=findViewById(R.id.price_editText)
        categoryEt=findViewById(R.id.category_editText)
        discountEt=findViewById(R.id.discount_editText)
        brandEt=findViewById(R.id.brand_editText)
        loadBtn=findViewById(R.id.load_button)
        saveBtn=findViewById(R.id.save_button)
        //set listeners ton the buttons
        loadBtn.setOnClickListener(this)
        saveBtn.setOnClickListener(this)
        database= Firebase.database
        databaseReference=database.reference.child("ProductDetails")

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
                    val intent= Intent(this,ProductDetails::class.java)
                    startActivity(intent)

                }
                R.id.save_button->{
                    if (productIdEt.text.toString().isNotEmpty() &&
                        nameEt.text.toString().isNotEmpty() &&
                        descriptionEt.text.toString().isNotEmpty() &&
                        priceEt.text.toString().isNotEmpty() &&
                        categoryEt.text.toString().isNotEmpty() &&
                        discountEt.text.toString().isNotEmpty() &&
                        brandEt.text.toString().isNotEmpty()){


                    val details=Details(
                            productIdEt.text.toString(),
                            nameEt.text.toString(),
                            descriptionEt.text.toString(),
                            priceEt.text.toString(),
                            categoryEt.text.toString(),
                            discountEt.text.toString(),
                            brandEt.text.toString()
                        )
                        databaseReference.push().setValue(details)
                        Toast.makeText(applicationContext,"Data Inserted", Toast.LENGTH_LONG).show()
                        productIdEt.text.clear()
                        nameEt.text.clear()
                        descriptionEt.text.clear()
                        priceEt.text.clear()
                        categoryEt.text.clear()
                       discountEt.text.clear()
                        brandEt.text.clear()


                    }

                }
            }


        }
    }
}