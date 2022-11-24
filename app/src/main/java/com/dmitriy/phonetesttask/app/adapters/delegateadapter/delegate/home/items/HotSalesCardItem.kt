package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

data class HotSalesCardItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val image: String,
    val isNew: Boolean,
    val isBuy: Boolean
) : ListItem {
    override val itemId: Long = id.toLong()
}