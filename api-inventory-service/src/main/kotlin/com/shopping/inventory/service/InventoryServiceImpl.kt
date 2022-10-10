package com.shopping.inventory.service

import com.shopping.inventory.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryServiceImpl(
    private val inventoryRepository: InventoryRepository
) : InventoryService {
    override fun isInStock(skuCode: String): Boolean {
        return inventoryRepository.existsBySkuCode(skuCode)
    }

}