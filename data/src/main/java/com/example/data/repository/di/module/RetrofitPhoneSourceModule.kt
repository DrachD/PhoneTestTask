package com.example.data.repository.di.module

import com.example.data.repository.datasources.RetrofitPhoneSource
import com.example.data.repository.datasources.RetrofitPhoneSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RetrofitPhoneSourceModule {

    @Binds
    abstract fun providePhoneSource(phoneSource: RetrofitPhoneSourceImpl): RetrofitPhoneSource
}