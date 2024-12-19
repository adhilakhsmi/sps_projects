package com.singlepointsol.personapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.singlepointsol.personapp.ui.theme.PersonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PersonAppTheme {
                PersonListScreen()
            }
        }
    }
}
