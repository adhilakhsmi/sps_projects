package com.singlepointsol.recyclar_grid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    //create image array
    val versionImageArray= arrayOf<Int>(R.drawable.baseline_as,R.drawable.baseline_airplay_24,R.drawable.baseline_app_shortcut_24,R.drawable.baseline_as,R.drawable.baseline_airplay_24,R.drawable.baseline_app_shortcut_24,R.drawable.baseline_as,R.drawable.baseline_airplay_24,R.drawable.baseline_app_shortcut_24,R.drawable.baseline_as,R.drawable.baseline_airplay_24,R.drawable.baseline_app_shortcut_24)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        recyclerView=findViewById(R.id.recycler_view)
        //load layout
        recyclerView.layoutManager=GridLayoutManager(this,3)
        recyclerView.adapter=VersionImageAdapter(versionImageArray)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}