package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.*

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
