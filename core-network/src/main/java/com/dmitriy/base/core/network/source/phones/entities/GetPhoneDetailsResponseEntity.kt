package com.dmitriy.base.core.network.source.phones.entities

data class GetPhoneDetailsResponseEntity(
    val CPU: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: String,
    var images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Float,
    val sd: String,
    val ssd: String,
    val title: String
)
