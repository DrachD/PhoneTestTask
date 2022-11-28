package com.dmitriy.phonetesttask.app.di.component

import com.dmitriy.phonetesttask.app.di.ActivityScope
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.CartFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface CartComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CartComponent
    }

    fun inject(fragment: CartFragment)
}