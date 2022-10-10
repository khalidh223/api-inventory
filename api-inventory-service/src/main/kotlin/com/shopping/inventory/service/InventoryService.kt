package com.shopping.inventory.service

interface InventoryService {
    fun isInStock(skuCode: String): Boolean
}