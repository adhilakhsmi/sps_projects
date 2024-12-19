package com.singlepointsol.employeedb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EmployeeDetails : AppCompatActivity(), ValueEventListener {
    lateinit var recyclerView:RecyclerView
    lateinit var employeeArrayList:ArrayList<Employee>
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_employee_details)
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager= LinearLayoutManager(this)
        employeeArrayList=ArrayList()
        getEmployees()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getEmployees() {
        databaseReference=FirebaseDatabase.getInstance().getReference ("Employees")
        databaseReference.addValueEventListener(this)
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()){
            for(employeesnapshot in snapshot.children){
               val emp= employeesnapshot.getValue(Employee::class.java)
                if (emp!=null){
                    employeeArrayList.add(emp)
                }

            }
            recyclerView.adapter=EmployeeAdapter(employeeArrayList)
        }
    }

    override fun onCancelled(error: DatabaseError) {

    }
}