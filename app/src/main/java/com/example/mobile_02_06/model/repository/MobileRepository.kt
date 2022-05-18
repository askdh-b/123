package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.Mobile

interface MobileRepository {

    suspend fun register(mobile: Mobile)

    suspend fun getMobile(appId: String)
}