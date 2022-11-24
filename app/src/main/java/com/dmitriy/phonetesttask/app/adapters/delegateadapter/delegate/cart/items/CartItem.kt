package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

data class CartItem(
    val items: List<ListItem>
) : ListItem {
    override val itemId: Long = 0
}
