package com.example.data.repository.di.module

import com.example.data.repository.Constants
import com.example.data.repository.PhonesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SourceProviderModule {

    @Singleton
    @Provides
    fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApi(retrofit: Retrofit): PhonesApi {
        return retrofit.create(PhonesApi::class.java)
    }
}