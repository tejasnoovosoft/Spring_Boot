package com.example.ioc

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface PrimaryQualifier {

}

@Component
@Primary
class Demo1 : PrimaryQualifier {

}

@Component("Demo2")
class Demo2 : PrimaryQualifier {

}

@Service
class ServiceClass(@Qualifier("Demo2") val primaryQualifier: PrimaryQualifier) {

}

