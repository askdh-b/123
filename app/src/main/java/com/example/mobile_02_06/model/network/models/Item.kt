package com.example.mobile_02_06.model.network.models

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String
)