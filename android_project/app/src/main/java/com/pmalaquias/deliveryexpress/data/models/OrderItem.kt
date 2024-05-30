package com.pmalaquias.deliveryexpress.data.models

data class OrderItem(
    val idOrderItems: Int,
    val idProducts: Products,
    val idOrders: Order,
    val quantity: Int,
    val totalPrice: Double,
    val unitPrice: Double
)
