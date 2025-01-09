package com.ic.mockserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockServerApplication

fun main(args: Array<String>) {
    runApplication<MockServerApplication>(*args)
}
