package com.pmalaquias.deliveryexpress.domain.entities

/**
 * Data class representing a User entity in the domain layer.
 *
 * @property id The unique identifier of the user.
 * @property name The name of the user.
 * @property email The email of the user.
 * @property password The password of the user.
 */
data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String
)
