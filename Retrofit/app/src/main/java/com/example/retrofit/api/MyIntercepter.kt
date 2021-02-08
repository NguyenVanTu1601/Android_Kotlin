package com.example.retrofit.api

import okhttp3.Interceptor
import okhttp3.Response
// dùng để add header request
class MyIntercepter:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
                .newBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("X-Platform","Android")
                .addHeader("X-Auth-Token","123456789")
                .build()
        return chain.proceed(request)
    }
}