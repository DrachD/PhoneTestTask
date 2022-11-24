package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.adapters

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.BaseDiffUtilItemCallback
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.HomeScreenDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class HotSalesAdapter : AsyncListDifferDelegationAdapter<ListItem>(
    BaseDiffUtilItemCallback()
) {

    init {
        delegatesManager
            .addDelegate(HomeScreenDelegates.hotSalesCardItem())
            .addDelegate(HomeScreenDelegates.hotSalesProgressItem())
    }
}