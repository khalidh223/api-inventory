package tests

import com.shopping.inventory.domain.InventoryEntity
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.next
import io.kotlintest.properties.Gen

fun Gen.Companion.inventoryEntity() = object : Gen<InventoryEntity> {
    override fun constants() = emptyList<InventoryEntity>()

    override fun random(): Sequence<InventoryEntity> = generateSequence {
        InventoryEntity(
            skuCode = string().random().first().take(8),
            quantity = Arb.int(1, 127).next()
        )
    }
}