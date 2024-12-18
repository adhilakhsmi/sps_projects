package com.singlepointsol.retropixafetchh

import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("?key=47624080-71fb117e0697725f0d5cf50eb&q=nature+images&image_type=photo")
    suspend fun getPixa(): Response<WallpaperResponse>


}