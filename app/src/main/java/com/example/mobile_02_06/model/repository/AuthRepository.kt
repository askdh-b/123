package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.AuthData
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.Token

interface AuthRepository {

    suspend fun login(authData: AuthData): ResultWrapper<Token>
}