package com.singlepointsol.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Employee::class])

class EmployeeDatabase {
    abstract class EmployeeDatabase:RoomDatabase(){
        companion object{
            const val NAME="employess_db"
        }
        abstract fun getEmployeeDao():EmployeeDao

    }
}