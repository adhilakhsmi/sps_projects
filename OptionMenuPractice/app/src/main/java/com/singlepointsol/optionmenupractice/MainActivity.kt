package com.singlepointsol.optionmenupractice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true // Indicate that the menu is successfully created
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.text_item -> {
                Toast.makeText(this, "This is text item", Toast.LENGTH_LONG).show()
                return true // Indicate the event was handled
            }
            R.id.color_item -> {
                Toast.makeText(this, "This is color item", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.bg_item -> {
                Toast.makeText(this, "This is bg item", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item) // Call the superclass for unhandled items
    }
}
