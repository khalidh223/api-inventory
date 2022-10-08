package com.shopping.inventory.repository

import com.shopping.inventory.domain.InventoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryRepository : JpaRepository<InventoryEntity, Long> {}