package com.shopping.inventory.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "inventory")
data class InventoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
    @Column(name = "sku_code")
    val skuCode: String,
    @Column(name = "quantity")
    val quantity: Int,
)