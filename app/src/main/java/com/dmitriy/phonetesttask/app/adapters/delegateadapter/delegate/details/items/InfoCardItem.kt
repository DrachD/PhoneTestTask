package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.items

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem

data class InfoCardItem(
    val id: String,
    val title: String,
    val cpu: String,
    val camera: String,
    val ssd: String,
    val sd: String,
    val colors: List<String>
) : ListItem {
    override val itemId: Long = id.hashCode().toLong()
}