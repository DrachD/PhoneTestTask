package com.dmitriy.phonetesttask.app.di.module

import com.dmitriy.phonetesttask.app.screens.main.tabs.home.DetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailsFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeDetailsFragmentInjector(): DetailsFragment
}