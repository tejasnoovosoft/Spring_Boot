package com.example.bank_trasanctions.controller

import com.example.bank_trasanctions.model.BankAccount
import com.example.bank_trasanctions.repository.BankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Suppress("UNREACHABLE_CODE")
@RestController
@RequestMapping("/api")
class BankController {

    @Autowired
    private lateinit var bankRepository: BankRepository

    @PostMapping("/createUser")
    fun createUser(@RequestBody account: BankAccount?): ResponseEntity<String> {
        if (account != null) {
            bankRepository.createAccount(account)
            return ResponseEntity.status(HttpStatus.OK).body("User Created With ${account.name}")
        }
        return ResponseEntity.status(HttpStatus.OK).body("Invalid User")
    }

    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<BankAccount>>? {
        val accounts: List<BankAccount>? = bankRepository.getAllAccounts()
        return if (accounts != null) {
            ResponseEntity.ok(accounts)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Int?): ResponseEntity<BankAccount> {
        val account: BankAccount? = id?.let { bankRepository.findUserById(id) }
        return account?.let {
            ResponseEntity.ok(account)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/user/delete/{id}")
    fun deleteUser(@PathVariable id: Int?): ResponseEntity<String> {
        val status = id?.let { bankRepository.deleteUser(it) }
        return if (status == true) {
            ResponseEntity.ok("User Deleted")
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/user/update/{id}")
    fun updateUser(@PathVariable id: Int?, @RequestBody account: BankAccount?): ResponseEntity<String> {
        if (id == null || account == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid User Data")
        }

        val status = bankRepository.updateUser(id, account)
        return if (status) {
            ResponseEntity.status(HttpStatus.OK).body("User Updated Successfully")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid User Data")
        }
    }

    @PatchMapping("/user/deposit/{id}")
    fun depositAmount(@PathVariable id: Int?, @RequestBody amount: Double?): ResponseEntity<String> {
        if (id == null || amount == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction Failed")
        }
        val deposit = bankRepository.depositAmount(id, amount)
        return if (deposit) {
            return ResponseEntity.status(HttpStatus.OK).body("Amount Deposited Successfully")
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction Failed")
        }
    }

    @PatchMapping("/user/withdraw/{id}")
    fun withdrawAmount(@PathVariable id: Int?, @RequestBody amount: Double?): ResponseEntity<String> {
        if (id == null || amount == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction Failed")
        }
        val withdraw = bankRepository.withdrawAmount(id, amount)
        return if (withdraw) {
            return ResponseEntity.status(HttpStatus.OK).body("Amount Withdraw Successfully")
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction Failed")
        }
    }

    @PatchMapping("/user/transfer/{senderId}/to/{receiverId}")
    fun transferAmount(
        @PathVariable senderId: Int?, @PathVariable receiverId: Int?, @RequestBody amount: Double?
    ): ResponseEntity<String> {
        if (senderId == null || receiverId == null || amount == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction Failed")
        }
        val transfer = bankRepository.transferAmount(senderId, receiverId, amount)
        return if (transfer) {
            ResponseEntity.ok("Transfer Amount Successfully")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transaction Failed")
        }
    }
}