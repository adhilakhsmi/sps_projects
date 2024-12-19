package com.singlepointsol.customerecyclerviewtask

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(private val fruitsArrayList: List<Fruits>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // ViewHolder class to hold item views
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitsImage: ImageView = itemView.findViewById(R.id.fruits_imageView)
        val fruitsName: TextView = itemView.findViewById(R.id.fruitnames_textView)
    }

    // Inflate item layout for ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruits_list, parent, false)
        return ViewHolder(view)
    }

    // set data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitsArrayList[position]
        holder.fruitsName.text = fruit.fruitsName
        holder.fruitsImage.setImageResource(fruit.fruitsImage)

        holder.fruitsImage.setOnClickListener(OnClickListener {
            val intent = Intent(it.context, FruitsDetailsActivity::class.java)
            //pass key to display fruit and image details
            intent.putExtra("fruitimage", fruit.fruitsImage)
            intent.putExtra("fruitname", fruit.fruitsName)
           //instead of this key here we use it.contect beacause it is not related to current class
            it.context.startActivity(intent)
        })

       }

    // size of ArrayList
    override fun getItemCount(): Int {
        return fruitsArrayList.size
    }
}
