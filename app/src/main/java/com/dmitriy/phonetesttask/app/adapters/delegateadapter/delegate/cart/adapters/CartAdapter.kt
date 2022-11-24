package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.adapters

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.CoreDiffUtilItemCallback
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.CartScreenDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CartAdapter : AsyncListDifferDelegationAdapter<ListItem>(CoreDiffUtilItemCallback()) {
    init {
        delegatesManager
            .addDelegate(CartScreenDelegates.cartItem())
    }
}