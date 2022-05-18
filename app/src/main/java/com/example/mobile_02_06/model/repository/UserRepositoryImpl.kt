package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.User
import com.example.mobile_02_06.model.network.NetworkService
import kotlinx.coroutines.CoroutineDispatcher

class UserRepositoryImpl(service: NetworkService, dispatcher: CoroutineDispatcher) :UserRepository {
    override suspend fun register(user: User) {

    }
}