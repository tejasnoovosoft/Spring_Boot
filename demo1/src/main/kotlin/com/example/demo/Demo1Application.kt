package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@SpringBootApplication
class Demo1Application

@Configuration
class Config {
    @Bean
    fun getInfo(): Employee {
        return Employee("Tejas")
    }

    @Bean
    @Primary
    fun getInformation(): Employee {
        return Employee("Vaishnav")
    }
}

fun main(args: Array<String>) {
    val context = runApplication<Demo1Application>(*args)
    val service = context.getBean(Employee::class.java)
    println(service.getInfo())
}