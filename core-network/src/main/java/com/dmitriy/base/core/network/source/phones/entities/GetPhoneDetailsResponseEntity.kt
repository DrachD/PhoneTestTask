package com.dmitriy.base.core.network.source.phones.entities

import com.google.gson.annotations.SerializedName

data class GetPhoneDetailsResponseEntity(
    @SerializedName("CPU") val CPU: String,
    @SerializedName("camera") val camera: String,
    @SerializedName("capacity") val capacity: List<String>,
    @SerializedName("color") val color: List<String>,
    @SerializedName("id") val id: String,
    @SerializedName("images") var images: List<String>,
    @SerializedName("isFavorites") val isFavorites: Boolean,
    @SerializedName("price") val price: Int,
    @SerializedName("rating") val rating: Float,
    @SerializedName("sd") val sd: String,
    @SerializedName("ssd") val ssd: String,
    @SerializedName("title") val title: String
)
