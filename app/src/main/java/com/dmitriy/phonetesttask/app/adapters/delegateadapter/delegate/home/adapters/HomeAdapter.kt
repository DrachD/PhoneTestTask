package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.adapters

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.CoreDiffUtilItemCallback
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.HomeScreenDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class HomeAdapter : AsyncListDifferDelegationAdapter<ListItem>(CoreDiffUtilItemCallback()
) {
    init {
        delegatesManager
            .addDelegate(HomeScreenDelegates.selectCategoryItem())
            .addDelegate(HomeScreenDelegates.hotSalesItem())
            .addDelegate(HomeScreenDelegates.bestSellerItem())
            //.addDelegate(HomeScreenDelegates.hotSalesCardItem())
    }
}