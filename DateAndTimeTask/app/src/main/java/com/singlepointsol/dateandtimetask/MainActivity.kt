package com.singlepointsol.dateandtimetask

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {

    // Late initialization
    private lateinit var from: EditText
    private lateinit var to: EditText
    private lateinit var dateBtn: Button
    private lateinit var timeBtn: Button
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Load views
        from = findViewById(R.id.from_et)
        to = findViewById(R.id.to_et)
        dateBtn = findViewById(R.id.date_btn)
        timeBtn = findViewById(R.id.time_btn)
        submitBtn = findViewById(R.id.submit_btn)

        // Set listeners
        dateBtn.setOnClickListener(this)
        timeBtn.setOnClickListener(this)
        submitBtn.setOnClickListener(this)

        // Adjust window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        when (v?.id) {
            R.id.time_btn -> {
                TimePickerDialog(this, this, hour, minute, true).show()
            }

            R.id.date_btn -> {
                DatePickerDialog(this, this, year, month, dayOfMonth).show()
            }

            R.id.submit_btn -> {
                // Check for empty EditText fields
                if (from.text.isEmpty() || to.text.isEmpty()) {
                    Toast.makeText(this, "Enter 'From' and 'To' details", Toast.LENGTH_LONG).show()
                } else if (from.text.toString().equals("Hyderabad", true) &&
                    to.text.toString().equals("Vizianagaram", true)
                ) {
                    // Create intent for navigation
                    val intent = Intent(this, BusReservationActivity::class.java).apply {
                        putExtra(KEY_FROM, from.text.toString())
                        putExtra(KEY_TO, to.text.toString())
                        putExtra(KEY_DATE, dateBtn.text.toString())
                        putExtra(KEY_TIME, timeBtn.text.toString())
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid 'From' and 'To' locations", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    companion object {
        const val KEY_FROM = "from"
        const val KEY_TO = "to"
        const val KEY_DATE = "date"
        const val KEY_TIME = "time"
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val timeselected="$p1:$p2"
        timeBtn.text=timeselected
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val dateselected="${p2+1}/$p3/$p2"
        dateBtn.text=dateselected
    }
}
