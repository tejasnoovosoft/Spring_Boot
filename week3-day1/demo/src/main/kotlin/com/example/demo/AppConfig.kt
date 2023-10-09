package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun userRepository(): UserRepository {
        return UserRepository()
    }

    @Bean
    fun userService(userRepository: UserRepository): UserService {
        return UserService(userRepository)
    }
}