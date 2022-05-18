package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.App
import com.example.mobile_02_06.model.network.models.AppInfo

interface AppRepository {

    suspend fun create(app: App): ResultWrapper<Void>

    suspend fun get(competitor: String): ResultWrapper<List<AppInfo>>
}