package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.Room
import com.example.mobile_02_06.model.models.Token
import com.example.mobile_02_06.model.network.NetworkService
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.AddedRoom
import com.example.mobile_02_06.model.network.safeCall
import kotlinx.coroutines.CoroutineDispatcher

class RoomRepositoryImpl(private val service: NetworkService, private val dispatcher: CoroutineDispatcher) :RoomRepository {
    override suspend fun create(room: Room): ResultWrapper<AddedRoom> = safeCall(dispatcher, apiCall = {
        service.createRoom(room.name, room.type, room.token, room.uuid)
    })

    override suspend fun get(token: Token): ResultWrapper<com.example.mobile_02_06.model.network.models.Room> = safeCall(dispatcher, apiCall = {
        service.getRooms(token.token, token.uuid)
    })
}