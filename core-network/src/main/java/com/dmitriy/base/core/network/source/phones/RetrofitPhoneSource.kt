package com.dmitriy.base.core.network.source.phones

import com.dmitriy.base.core.network.model.PhonesSource
import com.dmitriy.base.core.network.source.base.CoreRetrofitSource
import javax.inject.Inject

class RetrofitPhoneSource @Inject constructor(
    private val phonesApi: PhonesApi
) : CoreRetrofitSource(), PhonesSource {

    override suspend fun fetchListPhones() = wrapRetrofitException {
        phonesApi.getMainPhonesList()
    }

    override suspend fun fetchPhoneDetails() = wrapRetrofitException {
        phonesApi.getPhoneDetails()
    }

    override suspend fun fetchBasketList() = wrapRetrofitException {
        phonesApi.getAddedPhonesList()
    }
}