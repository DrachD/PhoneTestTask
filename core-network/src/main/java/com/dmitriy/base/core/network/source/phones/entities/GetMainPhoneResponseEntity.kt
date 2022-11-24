package com.dmitriy.base.core.network.source.phones.entities

data class GetMainPhoneResponseEntity(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)
