package com.singlepointsol.dateandtimetask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BusReservationActivity : AppCompatActivity(),OnClickListener {
    lateinit var title:TextView
    lateinit var fromtv:TextView
    lateinit var totv:TextView
    lateinit var date:TextView
    lateinit var pickuptime:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bus_reservation)
        //load views
        title=findViewById(R.id.title_tv)
        fromtv=findViewById(R.id.from_tv)
        totv=findViewById(R.id.to_tv)
        date=findViewById(R.id.datetime_tv)
        pickuptime=findViewById(R.id.pickup_tv)
        //receive key from main activity
        val fromValue: String = intent.getStringExtra("from").toString()
        val toValue: String = intent.getStringExtra("to").toString()
        val dateValue:String=intent.getStringExtra("date").toString()
        val pickupValue:String=intent.getStringExtra("time").toString()
        fromtv.text = fromValue
        totv.text = toValue
        date.text=dateValue
        pickuptime.text=pickupValue
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onClick(v: View?) {
        val intent= Intent(this,BusReservationActivity::class.java)
        startActivity(intent)
    }
}