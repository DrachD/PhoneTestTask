package com.dmitriy.phonetesttask.app.di.subcomponent

import com.dmitriy.phonetesttask.app.di.component.CartComponent
import com.dmitriy.phonetesttask.app.di.component.DetailsComponent
import com.dmitriy.phonetesttask.app.di.component.HomeComponent
import dagger.Module

@Module(subcomponents = [
    HomeComponent::class,
    DetailsComponent::class,
    CartComponent::class
])
class AppSubcomponent