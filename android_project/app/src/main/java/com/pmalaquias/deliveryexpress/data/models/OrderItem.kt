package com.pmalaquias.deliveryexpress.data.models

/**
 * Data class representing an OrderItem entity.
 *
 * @property idOrderItems Unique identifier for the order item.
 * @property idProducts Reference to the Products entity associated with this order item.
 * @property idOrders Reference to the Order entity associated with this order item.
 * @property quantity Quantity of the product ordered.
 * @property totalPrice Total price for this order item (quantity * unit price).
 * @property unitPrice Unit price of the product.
 */
data class OrderItem(
    val idOrderItems: Int,
    val idProducts: Products,
    val idOrders: Order,
    val quantity: Int,
    val totalPrice: Double,
    val unitPrice: Double
)