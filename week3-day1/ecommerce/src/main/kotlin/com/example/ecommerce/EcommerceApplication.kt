package com.example.ecommerce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EcommerceApplication

fun main(args: Array<String>) {
    val context = runApplication<EcommerceApplication>(*args)
    val application = context.getBean(ProductProcessing::class.java)
    println(application.performOperations())
}
