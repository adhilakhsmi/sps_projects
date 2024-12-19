package com.wsa.basiccomposeuidemo

import android.graphics.Paint.Align
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
@Composable
fun Myapp(modifier: Modifier = Modifier) {
    MaterialTheme {
        Surface (Modifier.fillMaxHeight().padding(16.dp))
        {
            LoginPage()
        }
        }
    }



@Composable
@Preview
fun LoginPage() {
    // State to store email, password, and phone input
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }

    // Initialize Firebase Database
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference: DatabaseReference = database.reference.child("LoginCredentials")
    val context= LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        // Text field for Email input
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Blue),
            placeholder = { Text("Enter Email") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Text field for Password input
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Blue),
            placeholder = { Text("Enter Password") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Text field for Phone input
        OutlinedTextField(
            value = phone.value,
            onValueChange = { phone.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Blue),
            placeholder = { Text("Enter Phone Number") }
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Button to submit data
        Button(
            onClick = {

                val logins = databaseReference.push().key // Generate unique key
                if (logins != null) {
                    val userData = mapOf(
                        "email" to email.value.trim(),
                        "password" to password.value.trim(),
                        "phone" to phone.value.trim()
                    )

                    // Save data in Firebase Realtime Database

                    databaseReference.child(logins).setValue(userData)
                        .addOnSuccessListener {
                           Toast.makeText(context,"Data saves successfully",Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { error ->
                            Log.e("Firebase", "Error saving data: ${error.message}")
                        }
                } else {
                    Log.e("Firebase", "Error: Unable to generate a key for the entry.")
                }
            }
        ) {
            Text(text = "Submit")
        }
    }
}
