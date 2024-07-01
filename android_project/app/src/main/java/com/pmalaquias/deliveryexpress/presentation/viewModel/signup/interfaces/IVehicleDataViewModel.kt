package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

import com.pmalaquias.deliveryexpress.data.models.enums.VehicleColor
import com.pmalaquias.deliveryexpress.data.models.enums.VehicleType

/**
 * An interface that defines the properties and methods for managing vehicle data in a ViewModel.
 *
 * This interface is designed to be implemented by ViewModel classes that need to handle user vehicle data, such as vehicle type, model, plate, and color.
 */
interface IVehicleDataViewModel {

    /**
     * The type of the user's vehicle.
     */
    var vehicleType : VehicleType

    /**
     * The model of the user's vehicle.
     */
    var vehicleModel : String

    /**
     * The plate number of the user's vehicle.
     */
    var vehiclePlate : String

    /**
     * The color of the user's vehicle.
     */
    var vehicleColor : VehicleColor

    /**
     * Updates the value of the "vehicleType" field.
     *
     * @param vehicleType The new value of the "vehicleType" field.
     */
    fun onVehicleTypeChange(vehicleType: VehicleType)

    /**
     * Updates the value of the "vehicleModel" field.
     *
     * @param vehicleModel The new value of the "vehicleModel" field.
     */
    fun onVehicleModelChange(vehicleModel: String)

    /**
     * Updates the value of the "vehiclePlate" field.
     *
     * @param vehiclePlate The new value of the "vehiclePlate" field.
     */
    fun onVehiclePlateChange(vehiclePlate: String)

    /**
     * Updates the value of the "vehicleColor" field.
     *
     * @param vehicleColor The new value of the "vehicleColor" field.
     */
    fun onVehicleColorChange(vehicleColor: VehicleColor)

    /**
     * Submits the vehicle data entered by the user.
     *
     * This function should be called when the user clicks the "Submit" button on the vehicle data screen.
     */
    fun onVehicleSubmit()

    /**
     * Validates the vehicle data entered by the user.
     *
     * This function checks whether all the input fields on the vehicle data screen have been filled out.
     *
     * @return true if all the input fields have been filled out, false otherwise.
     */
    fun validateVehicleData(): Boolean

    /**
     * Clears the error state of the ViewModel.
     *
     * This function should be called when the user has acknowledged an error message, to remove the error message from the UI.
     */
    fun clearError()

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    fun showError(message: String)

    /**
     * Returns whether the ViewModel is currently loading data.
     *
     * @return true if the ViewModel is currently loading data, false otherwise.
     */
    fun isLoading(): Boolean

    /**
     * Resets the ViewModel to its initial state.
     *
     * This function should be called when the user wants to enter new vehicle data, to clear the old data from the UI.
     */
    fun resetVehicleData()
}