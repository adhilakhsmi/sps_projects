package com.singlepointsol.customrecyclarview

import Version
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VersionAdapter(private val versionArrayList:ArrayList<Version> ) : RecyclerView.Adapter<VersionAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val versionImage:ImageView=itemView.findViewById(R.id.version_imageView)
        val versionName:TextView=itemView.findViewById(R.id.version_textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return versionArrayList()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}
