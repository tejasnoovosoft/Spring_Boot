package com.example.day1

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.support.ClassPathXmlApplicationContext

@SpringBootApplication
class Day1Application

@Configuration
class AppConfig {
    @Bean
    fun myService(): MyService {
        return MyService()
    }

    @Bean
    @Primary
    fun myService2() : MyService{
        return MyService()
    }

    @Bean
    fun studService(): Student {
        val service = Student()
        service.setMessage("Hey Student1")
        return service
    }

    @Bean
    fun personService(): Person {
        return Person("Tejas", 49)
    }
}

fun main(args: Array<String>) {
    val context = runApplication<Day1Application>(*args)
    val myService = context.getBean(MyService::class.java)
    println(myService.getMessage())

    val context2 = ClassPathXmlApplicationContext("config.xml")
    val myService2 = context2.getBean("student1") as Student
    println(myService2.getMessage1())

    val context3 = AnnotationConfigApplicationContext(AppConfig::class.java)
    val personService = context3.getBean(Person::class.java)
    println(personService.toString())


    context.close()
}
