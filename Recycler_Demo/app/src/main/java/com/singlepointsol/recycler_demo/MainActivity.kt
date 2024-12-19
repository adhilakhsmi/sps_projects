package com.singlepointsol.recycler_demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var frndsArray = arrayOf("adhi", "alekya", "kavitha", "sruthi","paddu","chaithhu","usha","anjali","abhi","pavan","praveen","swathi","anirudh","akhilesh","shashank","karthik","Srikar","usha","anjali","abhi","pavan","praveen","swathi","anirudh","akhilesh","shashank","karthik","Srikar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load view
        recyclerView = findViewById(R.id.recycler_view)
        //choose layout
        recyclerView.layoutManager = LinearLayoutManager(this)
        // added line
        recyclerView.adapter = FrndsAdapter(frndsArray)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



}

