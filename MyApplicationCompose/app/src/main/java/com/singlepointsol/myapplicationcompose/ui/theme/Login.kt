package com.singlepointsol.myapplicationcompose.ui.theme

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.singlepointsol.myapplicationcompose.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable

fun Login() {
    // State to store email and password input
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // Display an image from resources
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "google",
            modifier = Modifier
                .padding(16.dp)
                .size(80.dp) // Adjust the size as needed
        )
        Text(text="Login to your account")

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
        Spacer(modifier = Modifier.height(32.dp))

        // Row for buttons
        val context = LocalContext.current
            Button(onClick = { val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.naukri.com/nlogin/login?msg=0&URL=https%3A%2F%2Fmy.naukri.com%3A80")
            )
                context.startActivity(intent)
            })


            {
                Text(text = "Login",
                   )
            }
        Spacer(modifier = Modifier.height(32.dp))
            TextButton({}) {
                Text(text="Forgot Password?", modifier = Modifier.clickable { })

            }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text="Or Sign in with",
           )

        Row(modifier = Modifier.fillMaxWidth().padding(40.dp), horizontalArrangement = Arrangement.SpaceEvenly)
        {

         Image(painter = painterResource(id=R.drawable.img_2),
             contentDescription = "Google",
             modifier =Modifier
                 .size(40.dp)
                 .clickable {val intent=Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://mail.google.com/mail/u/0/?hl=in#inbox")
                 )
                     context.startActivity(intent)


                 }
             )
            Image(painter = painterResource(id=R.drawable.img_3),
                contentDescription = "Twitter",
                modifier =Modifier
                    .size(40.dp)
                    .clickable {
                        val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://x.com/Log%20in/"))
                        context.startActivity(intent)

                    }
            )
            Image(painter = painterResource(id=R.drawable.img_7),
                contentDescription = "Linked In",
                modifier =Modifier
                    .size(40.dp)
                    .clickable {
                        val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/login")
                        )
                        context.startActivity(intent)


                    }
            )
            val context = LocalContext.current
            Image(painter = painterResource(id=R.drawable.img_6),
                contentDescription = "Facebook",
                modifier =Modifier
                    .size(40.dp)
                    .clickable{
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/")
                        )
                        context.startActivity(intent)




                    }
            )





        }


        }
    }


