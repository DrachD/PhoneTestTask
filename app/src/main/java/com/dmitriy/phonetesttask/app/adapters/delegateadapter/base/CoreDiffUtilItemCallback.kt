package com.dmitriy.phonetesttask.app.adapters.delegateadapter.base

import androidx.recyclerview.widget.DiffUtil

open class CoreDiffUtilItemCallback : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.equals(newItem)
    }
}