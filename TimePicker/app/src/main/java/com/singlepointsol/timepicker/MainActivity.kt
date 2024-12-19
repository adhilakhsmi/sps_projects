package com.singlepointsol.timepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity(), View.OnClickListener,TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener{
    lateinit var timepicker:Button
    lateinit var datepicker:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load views
        timepicker=findViewById(R.id.time_picker_button)
        datepicker=findViewById(R.id.date_picker)
        timepicker.setOnClickListener(this)
        datepicker.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val c= Calendar.getInstance()
        val hour:Int=c.get(Calendar.HOUR_OF_DAY)
        val minute:Int=c.get(Calendar.MINUTE)
        val year:Int=c.get(Calendar.YEAR)
        val month:Int=c.get(Calendar.MONTH)
        val day_of_month=c.get(Calendar.DAY_OF_MONTH)

        if(p0!=null){
            when(p0.id){
                R.id.time_picker_button->{
                    TimePickerDialog(this,this,hour,minute,true).show()
                }
                R.id.date_picker->{
                    DatePickerDialog(this,this,year,month,day_of_month).show()
                }
            }


        }
    }


    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val timeselected="$p1:$p2"
        timepicker.text=timeselected

    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val dateselected="${p2+1}/$p3/$p2"
        datepicker.text=dateselected
    }


}