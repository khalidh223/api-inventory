package com.shopping.inventory.retrofit

import com.shopping.inventory.model.InventoryRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface InventoryApi {
    @POST("api/inventory")
    fun productsAreInStock(@Body request: InventoryRequest): Call<Boolean>
}