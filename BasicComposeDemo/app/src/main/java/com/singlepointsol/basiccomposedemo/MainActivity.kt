package com.singlepointsol.basiccomposedemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.wsa.basiccomposeuidemo.LoginPage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPage()/*
            Column {
                Text(
                    text = "Hello Android!",
                    color = Color.Cyan,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                )

                Text(
                    text = "Let's write text lines",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Thin,
                )

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val context = LocalContext.current
                    Button(onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://developer.android.com/develop/ui/compose/text/style-text")
                        )
                        context.startActivity(intent) // Correct usage of context to start an activity
                    }) {
                        Text(text = "Click Me")
                    }
                    ElevatedButton(onClick = {
                        Toast.makeText(context, "button clicked", Toast.LENGTH_LONG).show()
                    }) {
                        Text(text = "Click here")
                    }
                }


            }
            */

        }
    }
}








