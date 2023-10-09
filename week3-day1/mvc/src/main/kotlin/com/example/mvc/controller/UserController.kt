package com.example.mvc.controller

import com.example.mvc.models.User
import com.example.mvc.models.UserData
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserController {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello"
    }

    @GetMapping("/{id}")
    fun getData(@PathVariable id: Long): String {
        return "Data Associated With $id id"
    }

    @PostMapping("/add")
//    @RequestMapping("/add", method = [RequestMethod.POST])

    fun addData(@RequestBody userData: UserData) {
        println("New User ${userData.username} added successfully")
    }

//    @GetMapping("/user")
//    fun userDetails(@MatrixVariable(name = "username") username: String): String {
//        return "User: $username"
//    }

    @GetMapping("/user")
    fun getUserById(@RequestParam id: Int): String {
        return "User with : $id"
    }

    @GetMapping("/set-cookie")
    fun setCookie(response: HttpServletResponse): String {
        val cookie = Cookie("username", "tejas")
        response.addCookie(cookie)
        return "Cookie set successfully"
    }

    @GetMapping("/get-cookie")
    fun getCookie(@CookieValue("username", defaultValue = "Guest") username: String): String {
        return "Username from Cookie: $username"
    }

    @PostMapping("/user")
    fun addUser(@RequestBody user:User) : String{
        val id = user.id
        val username = user.username
        val email = user.email
        return "User Created With $id $username $email"
    }
}

// @Controller -> When you return a views (html,jsp)
// @RestController -> When you return a data in the form of JSON/XML
// @RequestHeader annotation to access HTTP headers in your controller methods