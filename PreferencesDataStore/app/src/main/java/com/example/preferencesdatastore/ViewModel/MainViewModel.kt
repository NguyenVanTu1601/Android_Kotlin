package com.example.preferencesdatastore.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.preferencesdatastore.Repository.DataStore_Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application : Application) : AndroidViewModel(application) {

    private var repository = DataStore_Repository(application)

    val readData = repository.readDataStore.asLiveData()

    fun saveData(myName : String){
        viewModelScope.launch(Dispatchers.IO){
            repository.saveToDataStore(myName)
        }
    }
}