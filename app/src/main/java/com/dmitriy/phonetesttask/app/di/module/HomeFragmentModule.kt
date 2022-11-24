package com.dmitriy.phonetesttask.app.di.module

import com.dmitriy.phonetesttask.app.screens.main.tabs.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragmentInjector(): HomeFragment
}