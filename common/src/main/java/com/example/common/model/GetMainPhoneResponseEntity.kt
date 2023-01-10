package com.example.common.model

data class GetMainPhoneResponseEntity(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)
