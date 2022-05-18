package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.Mobile
import com.example.mobile_02_06.model.network.NetworkService
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.KeyDev
import com.example.mobile_02_06.model.network.models.KeyDevice
import com.example.mobile_02_06.model.network.models.MobileInfo
import com.example.mobile_02_06.model.network.safeCall
import kotlinx.coroutines.CoroutineDispatcher

class MobileRepositoryImpl(private val service: NetworkService, private val dispatcher: CoroutineDispatcher) : MobileRepository {
    override suspend fun register(mobile: Mobile) : ResultWrapper<KeyDevice> = safeCall(dispatcher, apiCall = {
        service.registerMobile(MobileInfo(
            uuid = mobile.uuid,
            appId = mobile.appId,
            device = mobile.device
        ))
    })

    override suspend fun getMobile(appId: String): ResultWrapper<List<MobileInfo>> = safeCall(dispatcher, apiCall = {
        service.getMobiles(appId)
    })

    override suspend fun patchMobile(uuid: String): ResultWrapper<KeyDevice> = safeCall(dispatcher, apiCall = {
        service.patchMobile(uuid)
    })
}