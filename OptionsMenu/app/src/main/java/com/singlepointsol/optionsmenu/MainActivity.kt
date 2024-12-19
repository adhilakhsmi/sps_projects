package com.singlepointsol.optionsmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onCreateOptionsMenu(menu: Menu) : Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        return when (item.itemId) {
            R.id.deepu -> {
                /*
                val deepuImageView:ImageView
                deepuImageView=findViewById(R.id.deepu_image)
                deepuImageView.setImageResource(R.drawable.deepu)

                 */
                val deepuIntent=Intent(this,MenuActivity::class.java)
                startActivity(deepuIntent)
                true
            }

            R.id.prathyu -> {
                val prathyuIntent = Intent(this, PrathyuActivity::class.java)
                startActivity(prathyuIntent)
                true
            }
            R.id.paddu -> {
                val padduuIntent = Intent(this, PadduActivity::class.java)
                startActivity(padduuIntent)
                true
            }

            R.id.chaithu -> {
                val chaithuIntent = Intent(this, MenuActivity::class.java)
                startActivity(chaithuIntent)
                true
            }
            R.id.usha -> {
                val newIntent = Intent(this, MenuActivity::class.java)
                startActivity(newIntent)
                true
            }


            else -> return super.onOptionsItemSelected(item)
        }
    }
}