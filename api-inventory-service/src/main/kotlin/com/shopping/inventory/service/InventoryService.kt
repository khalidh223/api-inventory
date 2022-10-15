package com.shopping.inventory.service

import com.shopping.inventory.model.InventoryRequest

interface InventoryService {
    fun productIsInStock(skuCode: String): Boolean
    fun productsAreInStock(skuCodeList: List<String>): Boolean
}