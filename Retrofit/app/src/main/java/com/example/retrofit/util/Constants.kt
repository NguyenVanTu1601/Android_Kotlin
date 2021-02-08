package com.example.retrofit.util

class Constants {
    // companion object nó giống kiểu static trong java
    // khi có companion thì có thể gọi trực tiếp Constants.BasrURL mà ko cần khởi tạo
    // base = BaseUrl() sau đó mới base.BASE_URL
    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/" // đường dẫn cơ sở
    }
}