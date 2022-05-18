package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.User
import com.example.mobile_02_06.model.network.NetworkService
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.Secure
import kotlinx.coroutines.CoroutineDispatcher

interface UserRepository {

    suspend fun register(user: User): ResultWrapper<Secure>
}