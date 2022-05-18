package com.example.mobile_02_06.model.repository

import com.example.mobile_02_06.model.models.Mobile
import com.example.mobile_02_06.model.network.ResultWrapper
import com.example.mobile_02_06.model.network.models.KeyDevice
import com.example.mobile_02_06.model.network.models.MobileInfo

interface MobileRepository {

    suspend fun register(mobile: Mobile): ResultWrapper<KeyDevice>

    suspend fun getMobile(appId: String): ResultWrapper<List<MobileInfo>>

    suspend fun patchMobile(uuid: String): ResultWrapper<KeyDevice>
}