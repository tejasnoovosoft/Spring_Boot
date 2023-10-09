package com.example.demo
class UserService(private val userRepository: UserRepository) {
    fun getUserDetails(userId: Int): String {
        val user = userRepository.getUserById(userId)
        return "User details: $user"
    }
}