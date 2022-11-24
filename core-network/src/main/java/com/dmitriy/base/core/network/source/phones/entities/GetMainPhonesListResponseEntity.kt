package com.dmitriy.base.core.network.source.phones.entities

import com.google.gson.annotations.SerializedName

data class GetMainPhonesListResponseEntity(
    @SerializedName("home_store") val home_store: List<GetMainPhoneResponseEntity>
)
