package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.adapters

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.CartScreenDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BasketAdapter : AsyncListDifferDelegationAdapter<ListItem>(
    com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.BaseDiffUtilItemCallback()
) {
    init {
        delegatesManager
            .addDelegate(CartScreenDelegates.cartCardItem())
            .addDelegate(CartScreenDelegates.cartProgressItem())
    }
}