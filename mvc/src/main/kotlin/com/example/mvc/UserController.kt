package com.example.mvc

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {

    private val userList = mutableListOf<User>()

    @PostMapping("/create")
    fun createUser(@RequestBody user: User): String {
        userList.add(user)
        return "User created: ${user.name} (${user.email})"
    }

    @GetMapping("/get")
    fun getUsers(): List<User> {
        return userList
    }

    @GetMapping("/get/{id}")
    fun getUser(@PathVariable id: Long): Any {
        val user = userList.firstOrNull { it.id == id }
        return user ?: "User not Found"
    }
}
