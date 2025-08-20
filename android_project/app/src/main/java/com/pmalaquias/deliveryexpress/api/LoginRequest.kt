package com.pmalaquias.deliveryexpress.api

// Data class approach
data class LoginRequest(
    val username: String,
    val password: String
)

// Plain class approach
class LoginRequestImp(
    val username: String,
    val password: String
) {
    // Add getters and setters if needed
}
