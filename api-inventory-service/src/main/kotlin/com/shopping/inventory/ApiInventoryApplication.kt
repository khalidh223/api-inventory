package com.shopping.inventory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiInventoryApplication

fun main(args: Array<String>) {
	runApplication<ApiInventoryApplication>(*args)
}
