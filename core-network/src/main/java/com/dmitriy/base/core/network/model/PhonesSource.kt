package com.dmitriy.base.core.network.model

import com.dmitriy.base.core.network.source.phones.entities.GetAddedPhonesListResponseEntity
import com.dmitriy.base.core.network.source.phones.entities.GetMainPhonesListResponseEntity
import com.dmitriy.base.core.network.source.phones.entities.GetPhoneDetailsResponseEntity
import com.dmitriy.base.core.utils.GeneralResponse

interface PhonesSource {

    suspend fun fetchListPhones(): GeneralResponse<GetMainPhonesListResponseEntity>
    suspend fun fetchPhoneDetails(): GeneralResponse<GetPhoneDetailsResponseEntity>
    suspend fun fetchBasketList(): GeneralResponse<GetAddedPhonesListResponseEntity>
}