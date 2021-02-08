package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId") // convert tên của trường myUserId thành tên userId khi get/post
    //Tuy nhiên ko cần cũng được, khi ấy myUserId phải là userId để có thể convert được = gson
    val myUserId : Int,

    val id : Int,
    val title : String,
    val body : String
)
