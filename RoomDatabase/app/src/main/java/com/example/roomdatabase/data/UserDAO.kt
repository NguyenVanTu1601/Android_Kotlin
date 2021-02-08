package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.model.User

/**
 * https://developer.android.com/reference/android/arch/persistence/room/OnConflictStrategy
 */
@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : User)

    @Update
    suspend fun updateUser(user : User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllUser() : LiveData<List<User>>
}