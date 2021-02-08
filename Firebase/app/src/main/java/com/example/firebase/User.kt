package com.example.firebase

class User() {
    private var name : String = ""
    private var address : String = ""
    private var age : String = ""

    constructor(name : String, address : String, age : String) : this() {
        this.name = name
        this.address = address
        this.age = age
    }

    fun setName(name : String){
        this.name = name
    }

    fun getName() : String{
        return this.name
    }

    fun setAddess(address : String){
        this.address = address
    }

    fun getAddress() : String{
        return this.address
    }

    fun setAge(age : String){
        this.age = age
    }

    fun getAge() : String{
        return this.age
    }

}