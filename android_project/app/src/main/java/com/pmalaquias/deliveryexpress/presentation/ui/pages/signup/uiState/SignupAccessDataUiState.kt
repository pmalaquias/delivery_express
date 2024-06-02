package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState

/**
 * Data class representing the UI state for the signup access data screen.
 *
 * @property email The email of the user. Default value is an empty string.
 * @property confirmEmail The confirmation of the email of the user. Default value is an empty string.
 * @property password The password of the user. Default value is an empty string.
 * @property confirmPassword The confirmation of the password of the user. Default value is an empty string.
 * @property isLoading A boolean representing if the signup process is loading. Default value is false.
 */
data class SignupAccessDataUiState(
    val email: String = "",
    val confirmEmail: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
)
