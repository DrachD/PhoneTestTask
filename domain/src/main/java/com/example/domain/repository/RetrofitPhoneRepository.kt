package com.example.domain.repository

import com.example.common.model.GetAddedPhonesListResponseEntity
import com.example.common.model.GetMainPhonesListResponseEntity
import com.example.common.model.GetPhoneDetailsResponseEntity
import com.example.domain.GeneralResponse

interface RetrofitPhoneRepository {

    suspend fun fetchListPhones(): GeneralResponse<GetMainPhonesListResponseEntity>
    suspend fun fetchPhoneDetails(): GeneralResponse<GetPhoneDetailsResponseEntity>
    suspend fun fetchBasketList(): GeneralResponse<GetAddedPhonesListResponseEntity>
}