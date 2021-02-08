package com.example.preferencesdatastore.Repository

import android.content.Context
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

const val PREF_NAME = "my_preference"

class DataStore_Repository (context : Context){

    // tạo object chứa dữ liệu
    private object PreferenceKeys{
        val name = stringPreferencesKey("my_name")
    }


    // khởi tạo dataStore có tên là PREF_NAME
    private val dataStore : DataStore<Preferences> = context.createDataStore(
        name = PREF_NAME
    )

    // save Name to preference với name = "my_name" được lưu trong object PreferenceKeys
    suspend fun saveToDataStore(name : String){
        dataStore.edit {
            preference->
            preference[PreferenceKeys.name] = name
        }
    }

    // read data // chú ý import Flow cho đúng
    // String là type của tham số my_name - tức là type của PreferenceKey.name, chứ ko phải type của giá trị trả về, nó trả về 1 Flow
    val readDataStore : Flow<String> = dataStore.data.catch { exception ->
        if (exception is IOException){
            Toast.makeText(context, exception.message.toString(),Toast.LENGTH_LONG ).show()
            emit(emptyPreferences())
        }else{
            throw exception
        }
    }.map {
        preference->
        val myName : String? = preference[PreferenceKeys.name] ?: "None" // nếu ko có kq thì trả về None
        myName.toString()
    }
}