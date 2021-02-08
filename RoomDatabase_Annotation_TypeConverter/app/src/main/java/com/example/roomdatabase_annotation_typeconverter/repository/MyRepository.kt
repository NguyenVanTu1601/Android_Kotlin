package com.example.roomdatabase_annotation_typeconverter.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase_annotation_typeconverter.data.MyDao
import com.example.roomdatabase_annotation_typeconverter.model.Person

class MyRepository(private val myDao: MyDao) {

    val readPerson: LiveData<List<Person>> = myDao.readPerson()

    suspend fun insertPerson(person: Person){
        myDao.insertPerson(person)
    }

}