package com.example.mobile_02_06.model.network.models

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("token") val token: String
)