package com.example.ecommerce

import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
    private val products: MutableList<Product> = mutableListOf()

    init {
        products.add(Product(1, "Product 1", 29.99))
        products.add(Product(2, "Product 2", 39.99))
        products.add(Product(3, "Product 3", 19.99))
    }

    fun getAllProducts(): List<Product> {
        return products
    }

    fun getProductById(id: Long): Product? {
        return products.find { it.id == id }
    }

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun updateProduct(product: Product) {
        val existingProduct = products.find { it.id == product.id }
        if (existingProduct != null) {
            val index = products.indexOf(existingProduct)
            products[index] = product
        } else {
            throw IllegalArgumentException("Product with ID ${product.id} not found")
        }
    }
}
