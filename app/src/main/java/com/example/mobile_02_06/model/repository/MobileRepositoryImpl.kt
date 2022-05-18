package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.Mobile
import com.example.mobile_02_06.model.network.NetworkService
import kotlinx.coroutines.CoroutineDispatcher

class MobileRepositoryImpl(service: NetworkService, dispatcher: CoroutineDispatcher) : MobileRepository {
    override suspend fun register(mobile: Mobile) {

    }

    override suspend fun getMobile(appId: String) {

    }
}