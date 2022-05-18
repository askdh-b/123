package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.Room
import com.example.mobile_02_06.model.models.Token
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.AddedRoom

interface RoomRepository {

    suspend fun create(room: Room): ResultWrapper<AddedRoom>

    suspend fun get(token: Token): ResultWrapper<com.example.mobile_02_06.model.network.models.Room>
}