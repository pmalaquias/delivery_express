package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState

/**
 * Data class representing the UI state for the signup personal data screen.
 *
 * @property name The name of the user. Default value is an empty string.
 * @property commercialName The commercial name of the user. Default value is an empty string.
 * @property birthDate The birth date of the user. Default value is an empty string.
 * @property id The id of the user. Default value is 0.
 * @property phone The phone number of the user. Default value is 0.
 * @property photo The photo of the user. Default value is an empty string.
 * @property isLoading A boolean representing if the signup process is loading. Default value is false.
 */
data class SignupPersonalDataUiState(
    val name: String = "",
    val commercialName: String = "",
    val birthDate: String = "",
    val id: Int = 0,
    val phone: Int = 0,
    val photo: String = "",
    val isLoading: Boolean = false,
)
