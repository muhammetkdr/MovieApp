package com.muhammetkudur.common

import com.muhammetkudur.common.networkresponse.NetworkResponse

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

fun <I:Any,O:Any> NetworkResponse<I>.mapNetworkResult(mapper:I.()-> O): NetworkResponse<O>{
    return when(this){
        is NetworkResponse.Error -> NetworkResponse.Error(this.error)
        is NetworkResponse.Success -> NetworkResponse.Success(mapper.invoke(this.data))
        NetworkResponse.Loading -> NetworkResponse.Loading
    }
}

val String.Companion.EMPTY: String by lazy { "" }
val Int.Companion.ONE_VALUE: Int by lazy { 1 }
