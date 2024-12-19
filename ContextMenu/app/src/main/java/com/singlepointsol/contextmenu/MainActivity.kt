package com.singlepointsol.contextmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var contextBtn:Button
    lateinit var titletext:TextView
    lateinit var parentLayout:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        contextBtn=findViewById(R.id.context_btn)
        titletext=findViewById(R.id.text_title)
        parentLayout=findViewById(R.id.main)
        //register for context menu
        registerForContextMenu(contextBtn)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.contextmenu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
       return when(item.itemId){
           R.id.text_item->{
               val updated="updated text"
               titletext.text= updated
               true
           }
           R.id.color_item->{
               contextBtn.setBackgroundColor(resources.getColor(R.color.white))
               true
           }
           R.id.bg_item->{
               parentLayout.setBackgroundResource(R.drawable.sketches)
               true

           }
           else->{
               return super.onContextItemSelected(item)
           }
       }
    }
}