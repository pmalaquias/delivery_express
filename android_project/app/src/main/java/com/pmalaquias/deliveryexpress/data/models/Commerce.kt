package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.*

/**
 * Data class representing a Commerce entity.
 *
 * @property idCommerce Unique identifier for the commerce.
 * @property commerceName Name of the commerce.
 * @property address Address of the commerce.
 * @property phone Phone number of the commerce.
 * @property operatingHours Operating hours of the commerce.
 * @property deliveryType Type of delivery service provided by the commerce.
 * @property rating Rating of the commerce.
 * @property deliveryFee Delivery fee charged by the commerce.
 * @property photo URL or path to the photo of the commerce.
 * @property status Current status of the commerce.
 */
data class Commerce (
    val idCommerce: Int,
    val commerceName: String,
    val address: String,
    val phone: Int,
    val operatingHours: String,
    val deliveryType: DeliveryType,
    val rating: Float,
    val deliveryFee: Float,
    val photo: String,
    val status: CommerceStatus
)