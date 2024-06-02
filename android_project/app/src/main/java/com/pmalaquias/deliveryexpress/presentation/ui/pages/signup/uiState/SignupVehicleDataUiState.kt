package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState

import com.pmalaquias.deliveryexpress.data.models.enums.VehicleColor
import com.pmalaquias.deliveryexpress.data.models.enums.VehicleType

/**
 * Data class representing the UI state for the signup vehicle data screen.
 *
 * @property vehicleType The type of the vehicle. It can be null if the user has not selected a vehicle type.
 * @property vehicleModel The model of the vehicle. Default value is an empty string.
 * @property vehiclePlate The plate number of the vehicle. Default value is an empty string.
 * @property vehicleColor The color of the vehicle. It can be null if the user has not selected a vehicle color.
 * @property isLoading A boolean representing if the signup process is loading. Default value is false.
 */
data class SignupVehicleDataUiState(
    val vehicleType: VehicleType? = null,
    val vehicleModel: String = "",
    val vehiclePlate: String = "",
    val vehicleColor: VehicleColor? = null,
    val isLoading: Boolean = false,
)
