package com.example.mobile_02_06.model.network.models

import com.google.gson.annotations.SerializedName

data class AddedRoom(
    @SerializedName("answer") val answer: String,
    @SerializedName("sha") val sha: String
)
