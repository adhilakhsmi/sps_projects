package com.singlepointsol.glidedemo

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var sampleImage:ImageView
    lateinit var shihtzuimage:ImageView
    lateinit var puppyimage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        sampleImage=findViewById(R.id.sampleimageView)
        shihtzuimage=findViewById(R.id.shihtzuimageView)
        puppyimage=findViewById(R.id.puppyimageview)
        val imageurl="https://tse1.mm.bing.net/th?id=OIP.FVDg-Z1Pe-H1O8ooXiRfiAHaE8&pid=Api&P=0&h=180"
        Glide.with(this).load(imageurl).into(sampleImage)
        val shihtzuurl="https://tse1.mm.bing.net/th?id=OIP.NEOiy9_ZDKsDwkCvI8gszwHaGe&pid=Api&P=0&h=180"
        Glide.with(this).load(shihtzuurl).into(shihtzuimage)
        val puppyurl="https://www.dogledesign.hu/wp-content/uploads/2021/02/shih-tzu003-scaled.jpg"
        Glide.with(this).load(puppyurl).into(puppyimage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}