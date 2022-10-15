package com.shopping.inventory.controller

import com.shopping.inventory.service.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/inventory")
class InventoryController(private val inventoryService: InventoryService) {

    @GetMapping("{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    fun productIsInStock(@PathVariable("skuCode") skuCode: String): Boolean {
        return inventoryService.productIsInStock(skuCode)
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    fun productsAreInStock(@RequestParam skuCode: List<String>): Boolean {
        return inventoryService.productsAreInStock(skuCode)
    }
}