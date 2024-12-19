package com.singlepointsol.e_commercedb

import android.os.Bundle
import android.widget.Toast
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
import java.util.ArrayList

class ProductDetails : AppCompatActivity(), ValueEventListener {
    //initialization
    lateinit var recyclerView:RecyclerView
    lateinit var  productDetailsArrayList:ArrayList<Details>
    lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_details)
        //loaad views
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)
        productDetailsArrayList= ArrayList()
        getDetails()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getDetails() {
databaseReference=FirebaseDatabase.getInstance().getReference().child("ProductDetails")
        databaseReference.addValueEventListener(this)
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            productDetailsArrayList.clear()
            for (productsnapshot in snapshot.children) {
                val p = productsnapshot.getValue(Details::class.java)
                if (p != null) {
                    productDetailsArrayList.add(p)
                }
            }

            recyclerView.adapter = ProductDetailsAdapter(productDetailsArrayList)
        }
    }

    override fun onCancelled(error: DatabaseError) {
        Toast.makeText(this@ProductDetails, "Failed to load data: ${error.message}", Toast.LENGTH_SHORT).show()
    }

}