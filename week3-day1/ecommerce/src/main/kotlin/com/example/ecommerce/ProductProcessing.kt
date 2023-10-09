package com.example.ecommerce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductProcessing(@Autowired private val productService: ProductService) {
    fun performOperations() {
        var allProducts = productService.getAllProducts()
        println("All Products:")
        allProducts.forEach { println(it) }

        val productIdToFind = 2L
        val foundProduct = productService.getProductById(productIdToFind)
        println("\nProduct with ID $productIdToFind:")
        println(foundProduct ?: "Product not found")

        val newProduct = Product(4, "Product 4", 20000.00)
        productService.addProduct(newProduct)
        println("New Product Added : $newProduct")

        val updateProduct = Product(2, "Update Product 2", 1300.00)
        productService.updateProduct(updateProduct)
        println("New Product Added : $updateProduct")

        allProducts = productService.getAllProducts()
        println("All Products:")
        allProducts.forEach { println(it) }
    }
}

//Component,Service,Repository,Controller,RestController,Configuration