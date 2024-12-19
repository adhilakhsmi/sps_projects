package com.singlepointsol.retropicsfetch

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Hit(
    @SerializedName("previewHeight")
    @Expose
    var previewHeight: Int = 0,

    @SerializedName("likes")
    @Expose
    var likes: Int = 0,

    @SerializedName("favorites")
    @Expose
    var favorites: Int = 0,

    @SerializedName("tags")
    @Expose
    var tags: String = "",

    @SerializedName("webformatHeight")
    @Expose
    var webformatHeight: Int = 0,

    @SerializedName("views")
    @Expose
    var views: Int = 0,

    @SerializedName("webformatWidth")
    @Expose
    var webformatWidth: Int = 0,

    @SerializedName("previewWidth")
    @Expose
    var previewWidth: Int = 0,

    @SerializedName("comments")
    @Expose
    var comments: Int = 0,

    @SerializedName("downloads")
    @Expose
    var downloads: Int = 0,

    @SerializedName("pageURL")
    @Expose
    var pageURL: String = "",

    @SerializedName("previewURL")
    @Expose
    var previewURL: String = "",

    @SerializedName("webformatURL")
    @Expose
    var webformatURL: String = "",

    @SerializedName("imageWidth")
    @Expose
    var imageWidth: Int = 0,

    @SerializedName("user_id")
    @Expose
    var userId: Int = 0,

    @SerializedName("user")
    @Expose
    var user: String = "",

    @SerializedName("type")
    @Expose
    var type: String = "",

    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @SerializedName("userImageURL")
    @Expose
    var userImageURL: String = "",

    @SerializedName("imageHeight")
    @Expose
    var imageHeight: Int = 0
)
