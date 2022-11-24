package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

data class InfoItem(
    val items: List<ListItem>
) : ListItem {
    override val itemId: Long = 0
}