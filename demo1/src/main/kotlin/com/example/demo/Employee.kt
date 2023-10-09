package com.example.demo

import org.springframework.beans.factory.annotation.Autowired

class Employee(@Autowired private val name:String) {
    fun getInfo(){
        println("Name : $name")
    }
}