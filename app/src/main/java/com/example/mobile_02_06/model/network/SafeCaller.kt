package com.example.mobile_02_06.model.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.BufferedInputStream
import java.io.IOException

suspend fun <T> safeCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> {
                    throwable.printStackTrace()
                    ResultWrapper.NetworkError
                }
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBodyFromString(throwable)
                    ResultWrapper.GenericError(code, ErrorResponse(errorResponse.orEmpty()))
                }
                else -> {
                    ResultWrapper.GenericError(error = ErrorResponse("Нет данных, попробуйте позже"))
                }
            }
        }
    }
}

private fun convertErrorBodyFromString(throwable: HttpException): String? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val inputStream = BufferedInputStream(it.inputStream())
            val contents = ByteArray(1024)

            var bytesRead = 0
            var strFileContents: String? = null
            while (inputStream.read(contents).also { bytesRead = it } != -1) {
                strFileContents += String(contents, 0, bytesRead)
            }
            return strFileContents?.substring(4)
        }
    } catch (exception: Exception) {
        null
    }
}