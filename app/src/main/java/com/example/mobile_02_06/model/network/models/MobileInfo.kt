package com.example.mobile_02_06.model.network.models

import com.google.gson.annotations.SerializedName

data class MobileInfo(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("appId") val appId: String,
    @SerializedName("device") val device: String
)
