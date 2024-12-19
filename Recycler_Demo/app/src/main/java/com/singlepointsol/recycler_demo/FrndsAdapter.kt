package com.singlepointsol.recycler_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FrndsAdapter(val frndsArray: Array<String>) : RecyclerView.Adapter<FrndsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        //load views for items

        val frnds_name:TextView=itemView.findViewById(R.id.frnds_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate layout for viewholder
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
       return frndsArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //hold the daa
       holder.frnds_name.text=frndsArray[position]

    }

}
