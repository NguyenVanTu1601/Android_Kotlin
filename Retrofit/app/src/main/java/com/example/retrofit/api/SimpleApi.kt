package com.example.retrofit.api

import com.example.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @Headers(
            "Authorization : 123123123",
            "Platform : Android"
    )
    @GET("/posts/1")
    suspend fun getPost() : Response<Post> // trả về như này để ko bị lỗi nếu link sai

    // truyền id trên đường dẫn
    @GET("/posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number : Int
    ) : Response<Post>


    @GET("/posts") //https://jsonplaceholder.typicode.com/posts?userId=1
    suspend fun getCustomPost(
            @Query("userId") userId : Int
    ):Response<List<Post>>

    @GET("/posts") // https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
    suspend fun getCustomPostOrder(
            @Query("userId") userId : Int,
            @Query("_sort") sort : String,  //_sort = sort
            @Query("_order") order : String //_order = order
    ):Response<List<Post>>

    @GET("/posts") // https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
    suspend fun getCustomPostByMap(
            @Query("userId") userId : Int,
            @QueryMap options : Map<String, String>
    ) : Response<List<Post>>

    // post form định dạng json format
    @POST("posts")
    suspend fun pushPost(
            @Body post : Post
    ) : Response<Post>

    // postform dạng urlEncoded : là dạng thông tin truyền thẳng trên đường dẫn : userId=1&id=2&....
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
            @Field("userId") userId : Int,
            @Field("id") id : Int,
            @Field("title") title : String,
            @Field("body") body : String
    ) : Response<Post>


}