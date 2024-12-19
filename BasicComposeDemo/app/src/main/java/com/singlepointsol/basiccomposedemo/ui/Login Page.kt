package com.wsa.basiccomposeuidemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singlepointsol.basiccomposedemo.R


@Preview
@Composable
fun LoginPage() {
    // State to store email and password input
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image( painter = painterResource(R.drawable.sps))}
        // Text field for Email input
        OutlinedTextField(
            value = email.value, // Bind to the current state
            onValueChange = { email.value = it }, // Update state correctly
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text(text = "Email ID") }
        )


        // Text field for Password input
        OutlinedTextField(
            value = password.value, // Bind to the current state
            onValueChange = { password.value = it }, // Update state correctly
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text(text = "Password") }
        )

        // Row for buttons
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* Handle Sign-Up action */ },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = "Sign Up")
            }
            Button(onClick = { /* Handle Login action */ }) {
                Text(text = "Login")
            }
        }
    }
}
