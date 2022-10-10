package com.shopping.inventory.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
class InventoryControllerTests(
    @Autowired private val objectMapper: ObjectMapper,
    @Autowired private val context: WebApplicationContext,
) {
    private val mvc: MockMvc = (MockMvcBuilders.webAppContextSetup(context).build())

    @Test
    fun `GET of a product in the inventory repository by its skuCode should return that it is in stock when its quantity is greater than 0`{

    }

    @Test
    fun `GET of a product in the inventory repository by its skuCode should return that it is not in stock when its quantity is 0`{

    }

    @Test
    fun `GET of a product in the inventory repository by its skuCode should return 404 not found if that product doesn't exist`{

    }
}