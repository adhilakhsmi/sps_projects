package com.singlepointsol.optionsmenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.singlepointsol.friendsmenu.FriendsActivity
import com.singlepointsol.friendsmenu.R


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
        inflater.inflate(R.menu.optionmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        return when (item.itemId) {
            R.id.deepu -> {
                val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel: 9121655836"))
                startActivity(callIntent)
                true
            }

            R.id.prathyu -> {
                val newIntent = Intent(this, FriendsActivity::class.java)
                startActivity(newIntent)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}