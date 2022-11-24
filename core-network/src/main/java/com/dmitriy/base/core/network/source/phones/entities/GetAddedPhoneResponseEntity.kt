package com.dmitriy.base.core.network.source.phones.entities

import com.google.gson.annotations.SerializedName

data class GetAddedPhoneResponseEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("id") val images: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String
)
