package com.shopping.inventory.service

import com.shopping.inventory.model.InventoryRequest
import com.shopping.inventory.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryServiceImpl(
    private val inventoryRepository: InventoryRepository
) : InventoryService {
    override fun productIsInStock(skuCode: String): Boolean {
        val savedInventoryEntity = inventoryRepository.findBySkuCode(skuCode) ?: return false
        if (savedInventoryEntity.quantity == 0) {
            return false
        }
        return true
    }

    override fun productsAreInStock(skuCodeList: List<String>): Boolean {
        for (skuCode in skuCodeList) {
            val savedInventoryEntity = inventoryRepository.findBySkuCode(skuCode) ?: return false
            if (savedInventoryEntity.quantity == 0) {
                return false
            }
        }
        return true
    }
}
