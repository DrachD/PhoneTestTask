package com.example.data.repository.di.module

import com.example.data.repository.RetrofitPhoneRepositoryImpl
import com.example.domain.repository.RetrofitPhoneRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RetrofitPhoneRepositoryModule {

    @Binds
    abstract fun providePhoneRepository(phoneRepository: RetrofitPhoneRepositoryImpl): RetrofitPhoneRepository
}