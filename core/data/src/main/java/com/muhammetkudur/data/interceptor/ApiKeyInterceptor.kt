package com.muhammetkudur.data.interceptor

import com.muhammetkudur.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 *    Created By Muhammet KÜDÜR
 *    17.07.2023
 */

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url
            .newBuilder()
            .addQueryParameter(API_KEY_STRING, BuildConfig.API_KEY)
            .build()


        val requestBuilder = request.newBuilder()
            .url(url)

        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val API_KEY_STRING = "api_key"
    }
}