package com.singlepointsol.retropicsfetch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: PixabayAdapter
    private lateinit var pixabayService: PixabayService  // Declare pixabayService as a class-level variable

    private val map: HashMap<String, String> = hashMapOf(
        "key" to "47624080-71fb117e0697725f0d5cf50eb",  // Your actual API key
        "q" to "animal",  // Search query
        "image_type" to "all",  // Specify the image type
        "page" to "1"  // Page number
    )
    private var currentPage: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        rv = findViewById(R.id.recyclerView)
        rv.layoutManager = GridLayoutManager(this, 3)

        // Initialize CustomRetrofit and retrieve pixabayService
        val customRetrofit = CustomRetrofit(applicationContext)  // Pass ApplicationContext or ActivityContext
        pixabayService = customRetrofit.getService(PixabayService::class.java)

        // Call function to load images
        loadImages()

        // Handle edge-to-edge UI (if required for your app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Method to load images for the first page
    private fun loadImages() {
        val call: Call<PixabayResponse> = pixabayService.getImages(map)

        // Enqueue the call to make the request asynchronously
        call.enqueue(object : Callback<PixabayResponse> {
            override fun onResponse(
                call: Call<PixabayResponse>,
                response: Response<PixabayResponse>
            ) {
                if (response.isSuccessful) {
                    val pixabayResponse = response.body()
                    val hits: MutableList<Hit> = pixabayResponse?.hits?.toMutableList() ?: mutableListOf()
                    adapter = PixabayAdapter(this@MainActivity, hits)
                    rv.adapter = adapter
                    currentPage = 1
                } else {
                    Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Method to load the next page of images
    fun loadNextPage() {
        map["page"] = (currentPage + 1).toString()
        val call: Call<PixabayResponse> = pixabayService.getImages(map)

        // Enqueue the call to make the request asynchronously
        call.enqueue(object : Callback<PixabayResponse> {
            override fun onResponse(
                call: Call<PixabayResponse>,
                response: Response<PixabayResponse>
            ) {
                if (response.isSuccessful) {
                    val pixabayResponse = response.body()
                    val hits: List<Hit> = pixabayResponse?.hits ?: emptyList()
                    adapter.addItems(hits)  // Adding new items to the adapter
                    currentPage++
                } else {
                    Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
