package com.example.mvc.controller

import com.example.mvc.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserController {
    @GetMapping("/user")
    fun getUser(): String {
        return "Tejas"
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Int): String {
        return "User Associated With : $id id"
    }

    @GetMapping("/message")
    fun getMessage(): ResponseEntity<String> {
        val message = "Hello World"
        return ResponseEntity.status(HttpStatus.OK).body(message)
    }

    @PostMapping("/post")
    fun postMessage(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("POST Successful")
    }

    @GetMapping("/user/login")
    fun getUsers(@RequestParam name: String): String {
        return "Logged in user is $name"
    }

    @GetMapping("/user/credential")
    fun getUserCredential(
        @RequestParam(defaultValue = "test") id: String,
        @RequestParam(required = false) password: Any?
    ): String {
        return "User Id : ${id} and Password : $password"
    }

    @PostMapping("/user/map")
    fun mappingParameter(
        @RequestParam allParameters: Map<String, String>
    ): String {
        return "All Parameters = $allParameters"
    }

    @PostMapping("user/new")
    fun createUser(@RequestBody user: User): String {
        return "New User Created With ${user.name}"
    }


}