package com.example.demo

import org.springframework.beans.factory.annotation.Autowired

class Employee(private val name:String) {
    fun getInfo(){
        println("Name : $name")
    }
}