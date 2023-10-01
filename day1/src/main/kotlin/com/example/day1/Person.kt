package com.example.day1

class Person {
    private var personName: String
    private var personId: Int

    constructor(personName: String, personId: Int) {
        this.personName = personName
        this.personId = personId
    }

    override fun toString(): String {
        return "${this.personId} : ${this.personName}"
    }
}