package com.shopping.inventory.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.shopping.inventory.retrofit.InventoryApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.create

@Configuration
class RetrofitConfig {
    @Bean
    fun retrofit(objectMapper: ObjectMapper): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("http://inventory-service")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()

    @Bean
    fun inventoryApi(retrofit: Retrofit): InventoryApi =
        retrofit.create()
}