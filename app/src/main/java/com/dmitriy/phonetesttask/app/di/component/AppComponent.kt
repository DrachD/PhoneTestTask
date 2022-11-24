package com.dmitriy.phonetesttask.app.di.component

import com.dmitriy.base.core.network.di.module.SourceProviderModule
import com.dmitriy.phonetesttask.app.base.CoreApplication
import com.dmitriy.phonetesttask.app.di.module.CartFragmentModule
import com.dmitriy.phonetesttask.app.di.module.DetailsFragmentModule
import com.dmitriy.phonetesttask.app.di.module.HomeFragmentModule
import com.dmitriy.base.core.network.di.module.PhonesSourceModule
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