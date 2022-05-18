package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.model.network.NetworkService
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.Token
import com.example.mobile_02_06.model.network.safeCall
import kotlinx.coroutines.CoroutineDispatcher

class AuthRepositoryImpl(private val service: NetworkService, private val dispatcher: CoroutineDispatcher) : AuthRepository {

    override suspend fun login(authData: AuthData): ResultWrapper<Token> = safeCall(dispatcher, apiCall = {
        service.auth(
            email = authData.email,
            password = authData.password,
            uuid = authData.uuid
        )
    })
}