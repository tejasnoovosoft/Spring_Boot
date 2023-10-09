package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @Autowired
    val obj = CustomerService()

    @GetMapping("/list")
    fun getUserList() : List<Customer>{
        return obj.getUserList()
    }
}