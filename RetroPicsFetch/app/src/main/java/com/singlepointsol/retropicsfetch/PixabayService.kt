package com.singlepointsol.retropicsfetch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PixabayService {
    @GET("api/")
    fun getImages(@QueryMap params: Map<String, String>): Call<PixabayResponse>
}
