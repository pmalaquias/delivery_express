package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState

/**
 * Data class representing the UI state for the signup address data screen.
 *
 * @property street The street of the user's address. Default value is an empty string.
 * @property number The number of the user's address. Default value is 0.
 * @property zipCode The zip code of the user's address. Default value is 0.
 * @property complement The complement of the user's address. Default value is an empty string.
 * @property neighborhood The neighborhood of the user's address. Default value is an empty string.
 * @property city The city of the user's address. Default value is an empty string.
 * @property state The state of the user's address. Default value is an empty string.
 * @property maximumDistanceMap The maximum distance the user is willing to travel for deliveries. Default value is 0.0.
 * @property isLoading A boolean representing if the signup process is loading. Default value is false.
 */
data class SignupAddressDataUiState (
    val street: String = "",
    val number: Int= 0,
    val zipCode: Int = 0,
    val complement: String = "",
    val neighborhood: String = "",
    val city: String = "",
    val state: String = "",
    val maximumDistanceMap: Double = 0.0,
    val isLoading: Boolean = false,
)