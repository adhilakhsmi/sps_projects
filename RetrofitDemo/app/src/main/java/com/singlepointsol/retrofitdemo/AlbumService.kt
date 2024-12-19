package com.singlepointsol.retrofitdemo

import okhttp3.Response
import retrofit2.http.GET

interface AlbumService {
    @GET("/albums")
    suspend fun getAlbums():Response<Albums>
}