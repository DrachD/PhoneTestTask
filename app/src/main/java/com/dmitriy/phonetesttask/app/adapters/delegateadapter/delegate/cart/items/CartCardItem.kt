package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

data class CartCardItem(
    val id: Int,
    val title: String,
    val price: Int,
    val image: String
) : ListItem {
    override val itemId: Long = id.toLong()
}
