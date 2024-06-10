package com.pmalaquias.deliveryexpress.data.models

import java.util.Date

/**
 * Data class representing a User entity.
 *
 * @property id Unique identifier for the user.
 * @property firstName First name of the user.
 * @property lastName Last name of the user.
 * @property email Email address of the user.
 * @property password Password for the user. In a real-world application, this would be hashed and salted.
 * @property phone Phone number of the user.
 * @property address Address of the user.
 * @property photo URL or path to the photo of the user.
 * @property registerDate Date when the user registered.
 */
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phone: Int,
    val address: String,
    val photo: String,
    val registerDate: Date,
) {
    fun body(): User? {
        return null
    }
}