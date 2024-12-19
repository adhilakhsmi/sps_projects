package com.singlepointsol.retropicsfetch

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CustomRetrofit(private val context: Context) {  // Context passed to the constructor

    private val baseUrl = "https://pixabay.com/"

    fun <T> getService(serviceClass: Class<T>): T {
        return getRetrofit().create(serviceClass)
    }

    @Synchronized
    private fun getRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()

        val client = httpClient.build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}
