package com.example.data.repository

import com.example.data.repository.datasources.RetrofitPhoneSource
import com.example.domain.repository.RetrofitPhoneRepository
import javax.inject.Inject

class RetrofitPhoneRepositoryImpl @Inject constructor(
    private val phonesSource: RetrofitPhoneSource
) : RetrofitPhoneRepository {

    override suspend fun fetchListPhones() = phonesSource.fetchListPhones()
    override suspend fun fetchPhoneDetails() = phonesSource.fetchPhoneDetails()
    override suspend fun fetchBasketList() = phonesSource.fetchBasketList()
}