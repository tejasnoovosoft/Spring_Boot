package com.example.mvc.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class Controller {
    @GetMapping("/odd/{num}")
    fun checkOddNumber(@PathVariable num: Int): ResponseEntity<String> {
        if (num % 2 == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Enter Odd Number")
        }
        return ResponseEntity.status(HttpStatus.OK).body("$num is Odd Number")
    }
}