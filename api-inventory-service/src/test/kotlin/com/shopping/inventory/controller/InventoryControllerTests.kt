package com.shopping.inventory.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.shopping.inventory.repository.InventoryRepository
import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.properties.Gen
import io.kotlintest.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.junit.jupiter.Testcontainers
import tests.inventoryEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
class InventoryControllerTests(
    @Autowired private val inventoryRepository: InventoryRepository,
    @Autowired private val objectMapper: ObjectMapper,
    @Autowired private val context: WebApplicationContext,
) {
    private val mvc: MockMvc = (MockMvcBuilders.webAppContextSetup(context).build())

    @BeforeEach
    fun setup() {
        inventoryRepository.deleteAll()
    }

    @Test
    fun `GET of a product in the inventory repository by its skuCode should return that it is in stock when its quantity is greater than 0`(){
        val savedProduct = inventoryRepository.save(Gen.Companion.inventoryEntity().random().first().copy(quantity = 2))

        val response: Boolean = mvc.perform(
            MockMvcRequestBuilders.get("/api/inventory/${savedProduct.skuCode}")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk).andReturn().response.contentAsObject(objectMapper)

        inventoryRepository.findAll() shouldHaveSize 1
        response shouldBe true
    }

    @Test
    fun `GET of a product in the inventory repository by its skuCode should return that it is not in stock when its quantity is 0`(){
        val savedProduct = inventoryRepository.save(Gen.Companion.inventoryEntity().random().first().copy(quantity = 0))

        val response: Boolean = mvc.perform(
            MockMvcRequestBuilders.get("/api/inventory/${savedProduct.skuCode}")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk).andReturn().response.contentAsObject(objectMapper)

        inventoryRepository.findAll() shouldHaveSize 1
        response shouldBe false
    }

    private inline fun <reified T : Any> MockHttpServletResponse.contentAsObject(mapper: ObjectMapper = ObjectMapper()): T =
        mapper.readValue(this.contentAsString)
}