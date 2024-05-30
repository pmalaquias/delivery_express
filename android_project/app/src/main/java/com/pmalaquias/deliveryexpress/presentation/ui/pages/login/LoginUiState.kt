package com.pmalaquias.deliveryexpress.presentation.ui.pages.login

/**
 * Data class representing the state of the Login UI.
 *
 * @property email The email entered by the user in the login form. Default value is an empty string.
 * @property password The password entered by the user in the login form. Default value is an empty string.
 * @property isLoading A boolean flag indicating if the login process is ongoing. Default value is false.
 * @property error A string representing any error message that should be displayed in the UI. Default value is an empty string.
 */
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String = ""
)