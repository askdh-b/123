package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.AuthData

interface AuthRepository {

    suspend fun login(authData: AuthData)
}