package com.singlepointsol.roomdatabase

import androidx.room.Entity

@Entity(tableName = "employees_table")
data class Employee(val EmpName:String,val EmpPhone:String){

}
