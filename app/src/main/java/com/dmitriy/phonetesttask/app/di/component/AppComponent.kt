package com.dmitriy.phonetesttask.app.di.component

import com.dmitriy.base.core.network.di.module.SourceProviderModule
import com.dmitriy.base.core.network.di.module.PhonesSourceModule
import com.dmitriy.phonetesttask.app.di.subcomponent.AppSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    SourceProviderModule::class,
    PhonesSourceModule::class,
    AppSubcomponent::class
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun homeComponent(): HomeComponent.Factory
    fun detailsComponent(): DetailsComponent.Factory
    fun cartComponent(): CartComponent.Factory
}