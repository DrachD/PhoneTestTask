package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.adapters

import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.CoreDiffUtilItemCallback
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.DetailsScreenDelegates
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class InfoAdapter : AsyncListDifferDelegationAdapter<ListItem>(
    CoreDiffUtilItemCallback()
) {
    init {
        delegatesManager
            .addDelegate(DetailsScreenDelegates.infoCardItem())
            .addDelegate(DetailsScreenDelegates.infoProgressItem())
    }
}