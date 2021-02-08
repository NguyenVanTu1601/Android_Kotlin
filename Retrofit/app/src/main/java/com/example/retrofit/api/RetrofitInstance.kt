package com.example.retrofit.api

import com.example.retrofit.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// để kiểu là object vì muốn nó là 1 sigleton
// nghĩa là được khởi tạo 1 lần và có thể gọi trong suốt ứng dụng
object RetrofitInstance {

    // dùng khi custom header request gửi đi
    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyIntercepter())
    }.build()

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
                .client(client) // dùng khi custom header
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}