package com.example.retrofit.repository

import com.example.retrofit.api.RetrofitInstance
import com.example.retrofit.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost() : Response<Post>{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number : Int) : Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(numberUID : Int) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(numberUID)
    }

    suspend fun getCustomPostOrder(userID : Int, sort : String, order : String) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPostOrder(userID,sort,order)
    }

    suspend fun getCustomPostByMap(userId : Int, options : Map<String,String>) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPostByMap(userId, options)
    }

    suspend fun pushPost(post : Post) : Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost2(userId:Int, id:Int, title:String, body:String) : Response<Post>{
        return RetrofitInstance.api.pushPost2(userId,id,title,body)
    }
}