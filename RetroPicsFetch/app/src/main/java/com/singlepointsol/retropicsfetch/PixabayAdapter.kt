package com.singlepointsol.retropicsfetch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PixabayAdapter(
    private val context: Context,
    private var hits: MutableList<Hit>
) : RecyclerView.Adapter<PixabayAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recyclerView)  // Ensure the ID is correct
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hit = hits[position]
        // Load the image using an image loading library like Glide or Picasso
        Glide.with(context).load(hit.webformatURL).into(holder.imageView)
    }

    override fun getItemCount(): Int = hits.size

    // Method to add more items (for pagination)
    fun addItems(newItems: List<Hit>) {
        hits.addAll(newItems)
        notifyDataSetChanged()
    }
}
