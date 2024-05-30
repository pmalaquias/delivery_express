package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryType
import com.pmalaquias.deliveryexpress.data.models.enums.ProductStatus

/**
 * Data class representing a Products entity.
 *
 * @property idProducts Unique identifier for the product.
 * @property idCommerce Reference to the Commerce entity associated with this product.
 * @property productName Name of the product.
 * @property description Description of the product.
 * @property category Category of the product, represented by the DeliveryType enum.
 * @property unityPrice Unit price of the product.
 * @property photo URL or path to the photo of the product.
 * @property available Current availability status of the product, represented by the ProductStatus enum.
 * @property promotion Indicates whether the product is currently on promotion.
 */
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