package com.singlepointsol.recyclar_grid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class VersionImageAdapter( val versionImageArray: Array<Int>) : RecyclerView.Adapter<VersionImageAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val versionImageView:ImageView=itemView.findViewById(R.id.versionimageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return versionImageArray.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.versionImageView.setImageResource(versionImageArray[position])
        holder.versionImageView.setOnClickListener(View.OnClickListener {
            val intent= Intent(it.context,DetailsActivity::class.java)
            intent.putExtra("itemClicked",versionImageArray[position])
            it.context.startActivity(intent)
        })
    }

}
