package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryType
import com.pmalaquias.deliveryexpress.data.models.enums.ProductStatus

data class Products(
    val idProducts: Int,
    val idCommerce: Commerce,
    val productName: String,
    val description: String,
    val category: DeliveryType,
    val unityPrice: Double,
    val photo: String,
    val available: ProductStatus,
    val promotion: Boolean
)
