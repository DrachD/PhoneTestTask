package com.dmitriy.phonetesttask.app.di

import com.dmitriy.base.core.network.di.SourceProviderModule
import com.dmitriy.phonetesttask.app.base.CoreApplication
import com.dmitriy.phonetesttask.app.di.modules.CartFragmentModule
import com.dmitriy.phonetesttask.app.di.modules.DetailsFragmentModule
import com.dmitriy.phonetesttask.app.di.modules.HomeFragmentModule
import com.dmitriy.phonetesttask.app.di.modules.PhonesSourceModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        SourceProviderModule::class,
        HomeFragmentModule::class,
        DetailsFragmentModule::class,
        CartFragmentModule::class,
        PhonesSourceModule::class
    ]
)
interface AppComponent {
    fun inject(application: CoreApplication)
}