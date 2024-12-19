package com.singlepointsol.employeedb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter( val employeeArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val idtv:TextView=itemView.findViewById(R.id.id_tv)
   val nametv:TextView=itemView.findViewById(R.id.name_tv)
    val emailtv:TextView=itemView.findViewById(R.id.email_tv)
     val phonetv:TextView=itemView.findViewById(R.id.phone_tv)
     val designationtv:TextView=itemView.findViewById(R.id.designation_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.emp_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return employeeArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emp =  employeeArrayList[position]
        holder.idtv.text=emp.id
        holder.nametv.text = emp.name
        holder.emailtv.text=emp.email
        holder.phonetv.text=emp.phone
        holder.designationtv.text=emp.designation
    }

    }


