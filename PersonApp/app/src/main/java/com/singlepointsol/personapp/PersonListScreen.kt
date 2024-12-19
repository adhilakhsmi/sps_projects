package com.singlepointsol.personapp

import CustomItem
import Person
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Composable
fun PersonListScreen() {
    val context = LocalContext.current
    var personList by remember { mutableStateOf<List<Person>>(emptyList()) }

    // Firebase Database Reference
    val database = FirebaseDatabase.getInstance().getReference("persons")

    // Fetch data from Firebase
    LaunchedEffect(Unit) {
        database.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val persons = mutableListOf<Person>()
                for (personSnapshot in snapshot.children) {
                    val person = personSnapshot.getValue(Person::class.java)
                    person?.let { persons.add(it) }
                }
                personList = persons
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Error fetching data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    // Display data in LazyColumn
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(personList) { person ->
            CustomItem(person)        }
    }
}
