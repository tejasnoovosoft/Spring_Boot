package com.example.ioc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataService1 : Data {
    override fun data(): String {
        return "In DataService 1"
    }
}

@Service
class MyService {
    private lateinit var dataService: Data;

    @Autowired
    fun setDataService(dataService: Data) {
        this.dataService = dataService
    }
}

/*
@Service
class DataService(private val dataService: Data) {
    fun fetchData(): String {
        return dataService.data()
    }
}*/
