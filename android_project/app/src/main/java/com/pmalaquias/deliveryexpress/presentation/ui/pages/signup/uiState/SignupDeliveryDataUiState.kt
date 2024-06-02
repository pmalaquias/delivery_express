package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState

import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryType

/**
 * Data class representing the UI state for the signup delivery data screen.
 *
 * @property deliveryType The type of the delivery. It can be null if the user has not selected a delivery type.
 * @property isLoading A boolean representing if the signup process is loading. Default value is false.
 */
data class SignupDeliveryDataUiState(
    val deliveryType: DeliveryType?= null,
    val isLoading: Boolean = false,
)