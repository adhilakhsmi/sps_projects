package com.singlepointsol.customrecyclarview

import Version
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    lateinit var versionArrayList: ArrayList<Version>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //load views
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)
        versionArrayList= ArrayList()
        versionArrayList.add(Version(R.drawable.baseline_as,  "Baseline"))
        versionArrayList.add(Version(R.drawable.baseline_airplay_24,"airplay"))
        versionArrayList.add(Version(R.drawable.baseline_app_shortcut_24,"appShortcut"))


        recyclerView.adapter=VersionAdapter(versionArrayList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}