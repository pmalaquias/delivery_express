package com.pmalaquias.deliveryexpress.domain.entities

/**
 * Data class representing a Product entity in the domain layer.
 *
 * @property idProducts The unique identifier of the product.
 * @property name The name of the product.
 * @property description The description of the product.
 * @property price The price of the product.
 */
data class Product(
    val idProducts: Int,
    val name: String,
    val description: String,
    val price: Double,
)
