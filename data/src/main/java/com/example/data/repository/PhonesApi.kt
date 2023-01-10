package com.example.data.repository

import com.example.common.model.GetAddedPhonesListResponseEntity
import com.example.common.model.GetMainPhonesListResponseEntity
import com.example.common.model.GetPhoneDetailsResponseEntity
import retrofit2.Response
import retrofit2.http.GET

interface PhonesApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getMainPhonesList(): Response<GetMainPhonesListResponseEntity>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getPhoneDetails(): Response<GetPhoneDetailsResponseEntity>

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getAddedPhonesList(): Response<GetAddedPhonesListResponseEntity>
}