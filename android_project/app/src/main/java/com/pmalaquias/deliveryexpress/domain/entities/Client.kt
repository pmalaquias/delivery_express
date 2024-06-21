package com.pmalaquias.deliveryexpress.domain.entities

/**
 * Data class representing a Client in the domain layer.
 *
 * @property id The unique identifier of the client.
 * @property name The name of the client.
 * @property address The address of the client.
 */
data class Client (
    val id: Long,
    val name: String,
    val address: String
)