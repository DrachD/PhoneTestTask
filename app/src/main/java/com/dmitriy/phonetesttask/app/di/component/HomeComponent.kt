package com.dmitriy.phonetesttask.app.di.component

import com.dmitriy.phonetesttask.app.di.ActivityScope
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.HomeFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(fragment: HomeFragment)
}