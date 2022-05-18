package com.example.mobile_02_06.model.network

import com.example.mobile_02_06.model.network.models.*
import retrofit2.http.*

interface NetworkService {

    @POST("app")
    suspend fun createApp(@Body appInfo: AppInfo): Void

    @GET("app")
    suspend fun getApps(@Query("competitor") competitor: String): List<AppInfo>

    @POST("mobile")
    suspend fun registerMobile(@Body mobileInfo: MobileInfo): KeyDevice

    @GET
    suspend fun getMobiles(@Query("appId") appId: String): List<MobileInfo>

    @PATCH("mobile")
    suspend fun patchMobile(@Query("uuid") uuid: String): KeyDevice

    @POST("user")
    suspend fun register(
        @Header("email") email: String,
        @Header("name") name: String,
        @Header("password") password: String,
        @Header("uuid") uuid: String
    ): Secure

    @OPTIONS("user")
    suspend fun auth(
        @Header("email") email: String,
        @Header("password") password: String,
        @Header("uuid") uuid: String
    ): Token

    @POST("rooms")
    suspend fun createRoom(
        @Header("name") name: String,
        @Header("type") type: String,
        @Header("token") token: String,
        @Header("uuid") uuid: String
    ): AddedRoom

    @GET("rooms")
    suspend fun getRooms(
        @Header("token") token: String,
        @Header("uuid") uuid: String
    ): Room

    @PATCH("rooms/{id}")
    suspend fun patchRoom(
        @Path("id") id: String,
        @Header("name") name: String,
        @Header("type") type: String,
        @Header("token") token: String,
        @Header("uuid") uuid: String
    ): AddedRoom

    @DELETE("rooms/{id}")
    suspend fun deleteRoom(
        @Path("id") id: String,
        @Header("token") token: String,
        @Header("uuid") uuid: String
    ): AddedRoom
}