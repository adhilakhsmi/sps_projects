package com.singlepointsol.retropicsfetch

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PixabayResponse(
    @SerializedName("totalHits")
    @Expose
    val totalHits: Int = 0,

    @SerializedName("hits")
    @Expose
    val hits: List<Hit> = emptyList(),

    @SerializedName("total")
    @Expose
    val total: Int = 0
)
