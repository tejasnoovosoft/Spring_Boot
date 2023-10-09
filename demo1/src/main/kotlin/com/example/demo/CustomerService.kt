package com.example.demo

import org.springframework.stereotype.Service

@Service
class CustomerService {

    final var list: MutableList<Customer> = mutableListOf()

    init {
        var obj = Customer(1, "Tejas", 21, "Pune");
        list.add(obj)
        obj = Customer(2, "Vaishnav", 25, "Baner")
        list.add(obj)
    }

    fun getUserList(): List<Customer> {
        return list
    }
}