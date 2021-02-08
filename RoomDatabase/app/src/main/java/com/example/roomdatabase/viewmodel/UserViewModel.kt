package com.example.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.data.UserDatabase
import com.example.roomdatabase.repository.UserRepository
import com.example.roomdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<User>>
    private val repository : UserRepository
    init {
        var userDAO = UserDatabase.getDatabase(application).userDAO()
        repository = UserRepository(userDAO)
        readAllData = repository.readAllData
    }

    fun addUser(user : User){
        // Việc thêm user ta sẽ cho chạy trên một luông độc lập nên sẽ làm như này
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user : User){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteUser(user)
        }
    }

    fun deleteAllUsers(){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteAllUsers()
        }
    }
}