package com.example.mvc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PersonController {
    @GetMapping("/person")
    fun getPerson(): String {
        return "Tejas"
    }

    @GetMapping("/person/{id}")
    fun getPersonById(@PathVariable id: Int): String {
        return "Person Associated With $id : Tejas"
    }
}