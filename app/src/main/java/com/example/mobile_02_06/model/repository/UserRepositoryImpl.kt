package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.User
import com.example.mobile_02_06.model.network.NetworkService
import com.example.mobile_02_06.model.network.safeCall
import kotlinx.coroutines.CoroutineDispatcher

class UserRepositoryImpl(private val service: NetworkService, private val dispatcher: CoroutineDispatcher) :UserRepository {
    override suspend fun register(user: User) = safeCall(dispatcher, apiCall = {
        service.register(
            email = user.email,
            password = user.password,
            name = user.name,
            uuid = user.uuid
        )
    })
}