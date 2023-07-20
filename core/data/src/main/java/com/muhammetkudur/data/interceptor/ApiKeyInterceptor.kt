package com.muhammetkudur.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Singleton

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

@Singleton
class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url
            .newBuilder()
            .addQueryParameter(API_KEY_STRING, "d1f85d110b688bdc7c34ee9d5926f793")
            .build()

        val requestBuilder = request.newBuilder()
            .url(url)

        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val API_KEY_STRING = "api_key"
    }
}