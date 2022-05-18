package com.example.mobile_02_06.model.network.models

import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("items") val items: List<Item>,
    @SerializedName("sha") val sha: String
)
