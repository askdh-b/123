package com.example.mobile_02_06.model.storage

interface StorageService {

    fun setToken(token: String)

    fun getToken(): String
}