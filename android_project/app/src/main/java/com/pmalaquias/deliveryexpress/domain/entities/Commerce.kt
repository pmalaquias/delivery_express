package com.pmalaquias.deliveryexpress.domain.entities

/**
 * Data class representing a Commerce entity in the domain layer.
 *
 * @property id The unique identifier of the commerce.
 * @property name The name of the commerce.
 * @property address The address of the commerce.
 * @property email The email of the commerce.
 */
data class Commerce(
    val id: Long,
    val name: String,
    val address: String,
    val email: String,
)
