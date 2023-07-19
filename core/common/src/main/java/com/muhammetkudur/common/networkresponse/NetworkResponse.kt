package com.muhammetkudur.common.networkresponse

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

sealed class NetworkResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponse<T>()
    data class Error(val exception: Exception) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
}