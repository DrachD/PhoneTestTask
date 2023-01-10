package com.dmitriy.phonetesttask.app.di.component

import com.dmitriy.phonetesttask.app.di.subcomponent.AppSubcomponent
import com.example.data.repository.di.module.RetrofitPhoneRepositoryModule
import com.example.data.repository.di.module.RetrofitPhoneSourceModule
import com.example.data.repository.di.module.SourceProviderModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    SourceProviderModule::class,
    RetrofitPhoneSourceModule::class,
    RetrofitPhoneRepositoryModule::class,
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