package com.singlepointsol.retropixafetchh

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.retropixafetchh.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var wallpaperArrayList: ArrayList<Wallpaper>
    lateinit var wallpaperAdapter: WallpaperAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the RecyclerView with GridLayoutManager (3 columns)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Initialize the adapter and data list
        wallpaperArrayList = arrayListOf()
        wallpaperAdapter = WallpaperAdapter(wallpaperArrayList)
        recyclerView.adapter = wallpaperAdapter

        // Fetch data
        fetchWallpaperData()
    }

    // Coroutine scope to fetch data
    private fun fetchWallpaperData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.getRetrofitInstance()
                    .create(APIService::class.java)
                    .getPixa() // Call API (suspend function)

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val wallpaperList = response.body()?.hits ?: emptyList()

                        // Ensure we only take 15 items
                        wallpaperArrayList.clear()
                        wallpaperArrayList.addAll(wallpaperList.take(15))
                        wallpaperAdapter.notifyDataSetChanged()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace() // Log any exceptions for debugging
            }
        }
    }
}
