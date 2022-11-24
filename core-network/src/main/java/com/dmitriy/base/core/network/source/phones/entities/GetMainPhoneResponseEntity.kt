package com.dmitriy.base.core.network.source.phones.entities

import com.google.gson.annotations.SerializedName

data class GetMainPhoneResponseEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("is_new") val is_new: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("picture") val picture: String,
    @SerializedName("is_buy") val is_buy: Boolean
)
