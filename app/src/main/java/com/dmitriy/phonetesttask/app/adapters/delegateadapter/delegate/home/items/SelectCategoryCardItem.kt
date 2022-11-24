package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

data class SelectCategoryCardItem(
    val id: Int,
    val category: Int,
    val image: Int
) : ListItem {
    override val itemId: Long = id.toLong()
}