package com.example.mvc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GreetingController {

    @GetMapping("/greet")
    fun greet(): String {
        return "Hello, Kotlin Spring Boot!"
    }
}
