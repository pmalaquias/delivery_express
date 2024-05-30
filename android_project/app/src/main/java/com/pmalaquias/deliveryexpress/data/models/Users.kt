package com.pmalaquias.deliveryexpress.data.models

import java.util.Date

data class Users(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phone: Int,
    val address: String,
    val photo: String,
    val registerDate: Date,
)
