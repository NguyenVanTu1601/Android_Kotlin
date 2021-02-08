package com.example.scope_function

class Person(var name : String, var phone : String, var address : String, var age : Int) {

    fun moveAddress(address : String){
        this.address = address
    }

    fun changePhone(phone: String){
        this.phone = phone
    }

    fun displyInfo() : String{
        return this.name + " - " + this.address + " - " + this.phone + " - " + this.age
    }
}