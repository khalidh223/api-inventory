package com.shopping.inventory.service


interface InventoryService {
    fun productIsInStock(skuCode: String): Boolean
    fun productsAreInStock(skuCodeList: List<String>): Boolean
}