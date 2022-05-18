package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.network.NetworkService
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.App
import com.example.mobile_02_06.model.network.models.AppInfo
import com.example.mobile_02_06.model.network.safeCall
import kotlinx.coroutines.CoroutineDispatcher

class AppRepositoryImpl(private val service: NetworkService, private val dispatcher: CoroutineDispatcher) : AppRepository{
    override suspend fun create(app: App): ResultWrapper<Void> = safeCall(dispatcher, apiCall = {
        service.createApp(AppInfo(
            appId = app.appId,
            competitor = app.competitor
        ))
    })

    override suspend fun get(competitor: String): ResultWrapper<List<AppInfo>> = safeCall(dispatcher, apiCall = {
        service.getApps(competitor)
    })
}