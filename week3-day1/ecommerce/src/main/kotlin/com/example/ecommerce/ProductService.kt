package com.example.ecommerce

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(@Autowired private val productRepository: ProductRepository) {

    fun getAllProducts(): List<Product> {
        return productRepository.getAllProducts()
    }

    fun getProductById(id: Long): Product? {
        return productRepository.getProductById(id)
    }

    fun addProduct(product: Product) {
        productRepository.addProduct(product)
    }

    fun updateProduct(product: Product) {
        productRepository.updateProduct(product)
    }
}
