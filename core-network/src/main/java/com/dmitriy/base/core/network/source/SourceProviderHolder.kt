package com.dmitriy.base.core.network.source

import com.dmitriy.base.core.network.Constants
import com.dmitriy.base.core.network.source.phones.PhonesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class SourceProviderHolder {

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