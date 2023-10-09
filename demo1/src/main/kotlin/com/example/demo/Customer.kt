package com.example.demo

class Customer(val id:Long,val name: String,val age:Long,val location:String) {
    override fun toString(): String {
        return "Customer(id=$id, name='$name', age=$age, location='$location')"
    }
}