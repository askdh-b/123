package com.example.mobile_02_06.model.network.models

import com.google.gson.annotations.SerializedName

data class AppInfo(
    @SerializedName("appId") val appId: String,
    @SerializedName("competitor") val competitor: String
)