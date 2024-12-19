package com.singlepointsol.implicit_intent_task

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //late initialization
    lateinit var myntra:Button
    lateinit var amazon:Button
    lateinit var flipkart:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        myntra=findViewById(R.id.myntra_button)
        amazon=findViewById(R.id.amazon_button)
        flipkart=findViewById(R.id.flipkart_button)
        //set listeners
        myntra.setOnClickListener(this)
        amazon.setOnClickListener(this)
        flipkart.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if(view!=null){
            when(view.id){
                R.id.amazon_button-> {
                    val amazonintent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/"))
                    startActivity(amazonintent)
                }
                R.id.myntra_button->{

                    val myntraintent=Intent(Intent.ACTION_VIEW,Uri.parse("https://www.myntra.com/"))
                    startActivity(myntraintent)

                }
                R.id.flipkart_button->{
                    val flipkartintent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipkart.com/"))
                    startActivity(flipkartintent)
                }
            }
        }
    }
}