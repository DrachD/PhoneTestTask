package com.dmitriy.phonetesttask.app.di.component

import android.content.Context
import com.dmitriy.base.core.network.di.module.SourceProviderModule
import com.dmitriy.phonetesttask.app.base.CoreApplication
import com.dmitriy.phonetesttask.app.di.module.CartFragmentModule
import com.dmitriy.phonetesttask.app.di.module.DetailsFragmentModule
import com.dmitriy.phonetesttask.app.di.module.HomeFragmentModule
import com.dmitriy.base.core.network.di.module.PhonesSourceModule
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.CartFragment
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.DetailsFragment
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

//@Singleton
//@Component(
//    modules = [
//        AndroidInjectionModule::class,
//        SourceProviderModule::class,
//        HomeFragmentModule::class,
//        DetailsFragmentModule::class,
//        CartFragmentModule::class,
//        PhonesSourceModule::class
//    ]
//)
@Singleton
@Component(modules = [
    SourceProviderModule::class,
    PhonesSourceModule::class
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    //fun inject(application: CoreApplication)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: DetailsFragment)
    fun inject(fragment: CartFragment)
}