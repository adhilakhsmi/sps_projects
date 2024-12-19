package com.singlepointsol.jsondemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class EmployeeAdapter(private val employeesArray: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val empName:TextView=itemView.findViewById(R.id.name_tv)
        val empMail:TextView=itemView.findViewById(R.id.email_tv)
        val empPhone:TextView=itemView.findViewById(R.id.phone_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate layout
       val view=LayoutInflater.from(parent.context).inflate(R.layout.emp_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return employeesArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //set data to the viewholder
        val emp = employeesArray[position]
        holder.empName.text = emp.Name
        holder.empMail.text=emp.Email
        holder.empPhone.text=emp.Phone

    }

}
