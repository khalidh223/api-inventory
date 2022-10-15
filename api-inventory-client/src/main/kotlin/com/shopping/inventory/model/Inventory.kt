package com.shopping.inventory.model

import javax.persistence.Entity
import javax.persistence.Table

data class InventoryRequest(
    val skuCodeList: List<String>
)