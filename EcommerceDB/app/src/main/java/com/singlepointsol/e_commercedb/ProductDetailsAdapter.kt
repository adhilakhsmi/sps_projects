package com.singlepointsol.e_commercedb

import android.content.pm.PackageInstaller.PreapprovalDetails
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductDetailsAdapter(val productDetailsArrayList: ArrayList<Details>) : RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val productidtv: TextView =itemView.findViewById(R.id.product_id_tv)
        val nametv: TextView =itemView.findViewById(R.id.name_tv)
        val descriptiontv: TextView =itemView.findViewById(R.id.description_tv)
        val pricetv: TextView =itemView.findViewById(R.id.price_tv)
        val categorytv: TextView =itemView.findViewById(R.id.category_tv)
        val  discounttv:TextView=itemView.findViewById(R.id.discount_tv)
        val brandtv:TextView=itemView.findViewById(R.id.brand_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // initialize inflate layout
        val row=LayoutInflater.from(parent.context).inflate(R.layout.details_row,parent,false)
        return ViewHolder(row)
    }

    override fun getItemCount(): Int {
        return productDetailsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       //set data  to viewholder
        val prod_details=productDetailsArrayList[position]
        holder.productidtv.text=prod_details.product_id
        holder.nametv.text=prod_details.name
        holder.descriptiontv.text=prod_details.description
        holder.pricetv.text=prod_details.price
        holder.categorytv.text=prod_details.category
        holder.discounttv.text=prod_details.discount
        holder.brandtv.text=prod_details.brand
    }


}
