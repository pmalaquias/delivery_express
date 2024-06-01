package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup

data class SignupPersonalDataUiState(
    val name: String = "",
    val commercialName: String = "",
    val birthDate: String = "",
    val id: Int = 0,
    val phone: Int = 0,
    val photo: String = "",
    val isLoading: Boolean = false,
)
