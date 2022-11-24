package com.dmitriy.phonetesttask.app.di.modules

import com.dmitriy.base.core.network.model.PhonesSource
import com.dmitriy.base.core.network.source.phones.RetrofitPhoneSource
import dagger.Binds
import dagger.Module

@Module
abstract class PhonesSourceModule {

    @Binds
    abstract fun providePhonesSource(phonesSource: RetrofitPhoneSource): PhonesSource
}