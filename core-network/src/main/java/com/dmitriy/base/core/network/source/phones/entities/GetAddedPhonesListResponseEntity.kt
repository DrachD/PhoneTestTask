package com.dmitriy.base.core.network.source.phones.entities

import com.google.gson.annotations.SerializedName

data class GetAddedPhonesListResponseEntity(
    @SerializedName("basket") val basket: List<GetAddedPhoneResponseEntity>
)