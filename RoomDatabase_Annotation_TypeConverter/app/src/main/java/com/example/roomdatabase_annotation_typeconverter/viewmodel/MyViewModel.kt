package com.example.roomdatabase_annotation_typeconverter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase_annotation_typeconverter.data.MyDatabase
import com.example.roomdatabase_annotation_typeconverter.model.Person
import com.example.roomdatabase_annotation_typeconverter.repository.MyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {

    private val dao = MyDatabase.getDatabase(application).myDao()
    private val repository = MyRepository(dao)

    val readPerson: LiveData<List<Person>> = repository.readPerson

    fun insertPerson(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPerson(person)
        }
    }

}