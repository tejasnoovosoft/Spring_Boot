package com.example.day1

class Student {

    private var message: String = " "

    // Setter method for injecting the message dependency
    fun setMessage(message: String) {
        this.message = message
    }

    fun getMessage1(): String {
        return message
    }
}