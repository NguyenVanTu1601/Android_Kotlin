package com.example.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.data.UserDAO
import com.example.roomdatabase.model.User

class UserRepository(private val userDAO : UserDAO) {

    val readAllData : LiveData<List<User>> = userDAO.readAllUser()

    suspend fun addUser(user: User){
        userDAO.addUser(user)
    }

    suspend fun updateUser(user : User){
        userDAO.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDAO.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDAO.deleteAllUsers()
    }
}