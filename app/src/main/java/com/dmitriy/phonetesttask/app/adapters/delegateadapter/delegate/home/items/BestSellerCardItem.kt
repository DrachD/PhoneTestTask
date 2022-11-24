package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

class BestSellerCardItem(
    val id: Int,
    val brand: Int,
    val newPrice: Int,
    val oldPrice: Int,
    val image: Int
) : ListItem {
    override val itemId: Long = id.toLong()
}