package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.adapters

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.CoreDiffUtilItemCallback
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.DetailsScreenDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class DetailsAdapter : AsyncListDifferDelegationAdapter<ListItem>(
    CoreDiffUtilItemCallback()
) {
    init {
        delegatesManager
            .addDelegate(DetailsScreenDelegates.imageItem())
            .addDelegate(DetailsScreenDelegates.infoItem())
    }
}