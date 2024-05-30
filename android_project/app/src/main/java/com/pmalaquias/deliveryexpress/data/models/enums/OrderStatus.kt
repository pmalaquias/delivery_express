package com.pmalaquias.deliveryexpress.data.models.enums

/**
 * Enum class representing different statuses of an order.
 *
 * @property PENDING Represents an order status where the order is pending.
 * @property IN_PROGRESS Represents an order status where the order is in progress.
 * @property DELIVERED Represents an order status where the order has been delivered.
 * @property CANCELED Represents an order status where the order has been canceled.
 */
enum class OrderStatus {
    PENDING,
    IN_PROGRESS,
    DELIVERED,
    CANCELED
}