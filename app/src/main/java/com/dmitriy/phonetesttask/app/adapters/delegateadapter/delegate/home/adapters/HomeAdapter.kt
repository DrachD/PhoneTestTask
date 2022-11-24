package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.adapters

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.BaseDiffUtilItemCallback
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.HomeScreenDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class HomeAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()
) {
    init {
        delegatesManager
            .addDelegate(HomeScreenDelegates.selectCategoryItem())
            .addDelegate(HomeScreenDelegates.hotSalesItem())
            .addDelegate(HomeScreenDelegates.bestSellerItem())
            //.addDelegate(HomeScreenDelegates.hotSalesCardItem())
    }
}