package pt.project.logincontacts.network.sealed_response

import okhttp3.ResponseBody

sealed class Response <out T>{
    data class Success <out T>(val value: T): Response<T>()
    data class  Failure<out T>(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ):Response<T>()
}
