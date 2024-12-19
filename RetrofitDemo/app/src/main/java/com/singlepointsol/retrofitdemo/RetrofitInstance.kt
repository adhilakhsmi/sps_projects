package com.singlepointsol.retrofitdemo

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        val mainURL="https://jsonplaceholder.typicode.com/"//base URL

        fun getRetrofitInstnace():Retrofit{
            return Retrofit.Builder() //get instance of retrofit
                .baseUrl(mainURL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()) )//convert json into data using gson
                .build()


        }
    }
}