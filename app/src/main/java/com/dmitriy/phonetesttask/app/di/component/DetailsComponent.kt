package com.dmitriy.phonetesttask.app.di.component

import com.dmitriy.phonetesttask.app.di.ActivityScope
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.DetailsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface DetailsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailsComponent
    }

    fun inject(fragment: DetailsFragment)
}