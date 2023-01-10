package com.example.data.repository.datasources

import com.example.data.repository.PhonesApi
import com.example.data.repository.datasources.base.BaseRetrofitSource
import javax.inject.Inject

class RetrofitPhoneSourceImpl @Inject constructor(
    private val phonesApi: PhonesApi
) : BaseRetrofitSource(), RetrofitPhoneSource {

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