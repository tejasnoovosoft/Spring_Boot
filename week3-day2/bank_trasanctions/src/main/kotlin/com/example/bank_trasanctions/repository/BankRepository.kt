package com.example.bank_trasanctions.repository

import com.example.bank_trasanctions.model.BankAccount
import org.springframework.stereotype.Repository

@Repository
class BankRepository {
    private val accounts = mutableListOf<BankAccount>()

    fun createAccount(account: BankAccount) {
        accounts.add(account)
    }

    fun getAllAccounts(): List<BankAccount>? {
        return accounts
    }

    fun findUserById(id: Int): BankAccount? {
        return accounts.find { it.id == id }
    }

    fun deleteUser(id: Int): Boolean {
        val user = accounts.find { it.id == id }
        return if (user != null) {
            accounts.remove(user)
            true
        } else {
            false
        }
    }

    fun updateUser(id: Int?, account: BankAccount?): Boolean {
        if (account == null) {
            return false
        }

        val userIndex = account.let { accounts.indexOfFirst { it.id == account.id } }

        return if (userIndex != -1 && id == account.id) {
            accounts[userIndex] = account
            true
        } else {
            false
        }
    }

    fun depositAmount(id: Int?, amount: Double?): Boolean {

        if (id == null || amount == null || amount <= 0) {
            return false
        }

        val user = accounts.find { it.id == id }
        return if (user != null) {
            user.balance = (user.balance ?: 0.0) + amount
            true
        } else {
            false
        }
    }

    fun withdrawAmount(id: Int?, amount: Double?): Boolean {
        if (id == null || amount == null || amount <= 0) {
            return false
        }
        val user = accounts.find { it.id == id }
        return if (user != null && (user.balance ?: 0.0) > amount) {
            user.balance = (user.balance ?: 0.0) - amount
            true
        } else {
            false
        }
    }

    fun transferAmount(senderId: Int?, receiverId: Int?, amount: Double?): Boolean {

        if (senderId == null || receiverId == null || amount == null || senderId == receiverId) {
            return false
        }

        val sender = accounts.find { it.id == senderId }
        val receiver = accounts.find { it.id == receiverId }

        return if ((sender?.balance ?: 0.0) >= amount) {
            sender?.let {
                it.balance = (it.balance ?: 0.0) - amount
            }
            receiver?.let {
                it.balance = (it.balance ?: 0.0) + amount
            }
            true
        } else {
            false
        }
    }
}