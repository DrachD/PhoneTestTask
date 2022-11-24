package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

data class ImageCardItem(
    val image: String
) : ListItem {
    override val itemId: Long = image.hashCode().toLong()
}