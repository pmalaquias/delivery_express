package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState.SignupVehicleDataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel class for the SignUpVehicleData screen.
 *
 * @property _uiState Private MutableStateFlow of SignupVehicleDataUiState. Default value is an instance of SignupVehicleDataUiState.
 * @property uiState Public StateFlow of SignupVehicleDataUiState. It's a state flow version of _uiState.
 * @property vehicleType Mutable state of the vehicle type input field. Default value is an empty string.
 * @property vehicleModel Mutable state of the vehicle model input field. Default value is an empty string.
 * @property vehiclePlate Mutable state of the vehicle plate input field. Default value is an empty string.
 * @property vehicleColor Mutable state of the vehicle color input field. Default value is an empty string.
 * @property isLoading Mutable state of the loading state. Default value is false.
 */
class SignUpVehicleDataViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignupVehicleDataUiState())
    val uiState: StateFlow<SignupVehicleDataUiState> = _uiState.asStateFlow()

    var vehicleType by mutableStateOf("")
    var vehicleModel by mutableStateOf("")
    var vehiclePlate by mutableStateOf("")
    var vehicleColor by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    /**
     * Updates the vehicle type state.
     *
     * @param vehicleType The new value for the vehicle type state.
     */
    fun onVehicleTypeChange(vehicleType: String) {
        this.vehicleType = vehicleType
    }

    /**
     * Updates the vehicle model state.
     *
     * @param vehicleModel The new value for the vehicle model state.
     */
    fun onVehicleModelChange(vehicleModel: String) {
        this.vehicleModel = vehicleModel
    }

    /**
     * Updates the vehicle plate state.
     *
     * @param vehiclePlate The new value for the vehicle plate state.
     */
    fun onVehiclePlateChange(vehiclePlate: String) {
        this.vehiclePlate = vehiclePlate
    }

    /**
     * Updates the vehicle color state.
     *
     * @param vehicleColor The new value for the vehicle color state.
     */
    fun onVehicleColorChange(vehicleColor: String) {
        this.vehicleColor = vehicleColor
    }

    /**
     * Sets the loading state to true when the vehicle data is submitted.
     */
    fun onVehicleSubmit() {
        isLoading = true
    }

    /**
     * Resets all the vehicle data states to their default values.
     */
    fun resetVehicleData() {
        vehicleType = ""
        vehicleModel = ""
        vehiclePlate = ""
        vehicleColor = ""
    }

}