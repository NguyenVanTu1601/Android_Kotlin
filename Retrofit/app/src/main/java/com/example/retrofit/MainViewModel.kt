package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    fun getPost(){
        viewModelScope.launch {
            var response : Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number : Int){
        viewModelScope.launch {
            var response : Response<Post> = repository.getPost2(number)
            myResponse.value = response
        }
    }

    fun getCustomPost(numberUID : Int){
        viewModelScope.launch {
            myCustomPosts.value = repository.getCustomPost(numberUID)
        }
    }

    fun getCustomPostOrder(numberUID : Int, sort : String, order : String){
        viewModelScope.launch {
            myCustomPosts.value = repository.getCustomPostOrder(numberUID,sort, order)
        }
    }

    fun getCustomPostByMap(numberUID: Int, options: Map<String, String>){
        viewModelScope.launch {
            myCustomPosts.value = repository.getCustomPostByMap(userId = numberUID, options)
        }
    }

    fun pushPost(post : Post){
        viewModelScope.launch {
            myResponse.value = repository.pushPost(post)
        }
    }

    fun pushPost2(userId:Int, id:Int, title:String, body:String){
        viewModelScope.launch {
            myResponse.value = repository.pushPost2(userId,id,title,body)
        }
    }
}