package com.dmitriy.phonetesttask.app.di.module

import com.dmitriy.phonetesttask.app.screens.main.tabs.home.CartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CartFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeCartFragmentInjector(): CartFragment
}