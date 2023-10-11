package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    val context = runApplication<DemoApplication>(*args)
    val userService = context.getBean(UserService::class.java)
    println(userService.getUserDetails(20))
}
