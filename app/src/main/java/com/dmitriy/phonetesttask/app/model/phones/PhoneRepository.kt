package com.dmitriy.phonetesttask.app.model.phones

import com.dmitriy.base.core.network.model.PhonesSource
import javax.inject.Inject

class PhoneRepository @Inject constructor(
    private val phonesSource: PhonesSource
) {

    suspend fun fetchListPhones() = phonesSource.fetchListPhones()
    suspend fun fetchPhoneDetails() = phonesSource.fetchPhoneDetails()
    suspend fun fetchBasketList() = phonesSource.fetchBasketList()
}