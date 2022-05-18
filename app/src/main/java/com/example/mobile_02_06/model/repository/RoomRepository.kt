package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.Room
import com.example.mobile_02_06.model.models.Token

interface RoomRepository {

    fun create(room: Room)

    fun get(token: Token)

    fun patch(id: String, room: Room)

    fun delete(id: String, token: Token)
}