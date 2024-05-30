package com.pmalaquias.deliveryexpress.data.models.enums

/**
 * Enum class representing different types of deliveries.
 *
 * @property Food Represents a delivery type for food.
 * @property Clothing Represents a delivery type for clothing.
 * @property Documents Represents a delivery type for documents.
 * @property FragileOrder Represents a delivery type for fragile orders.
 * @property HeavyOrder Represents a delivery type for heavy orders.
 * @property Other Represents any other type of delivery not listed above.
 */
enum class DeliveryType {
    Food,
    Clothing,
    Documents,
    FragileOrder,
    HeavyOrder,
    Other,
}