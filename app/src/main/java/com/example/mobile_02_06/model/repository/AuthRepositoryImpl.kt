package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.model.network.NetworkService
import kotlinx.coroutines.CoroutineDispatcher

class AuthRepositoryImpl(service: NetworkService, dispatcher: CoroutineDispatcher) : AuthRepository {

    override suspend fun login(authData: AuthData) {

    }
}