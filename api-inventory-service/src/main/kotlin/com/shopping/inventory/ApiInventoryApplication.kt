package com.shopping.inventory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ApiInventoryApplication

fun main(args: Array<String>) {
	runApplication<ApiInventoryApplication>(*args)
}
