package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

/**
 * An interface that defines the properties and methods for managing address data in a ViewModel.
 *
 * This interface is designed to be implemented by ViewModel classes that need to handle user address data, such as street, number, zip code, etc.
 */
interface IAddressDataViewModel {

    /**
     * The user's street.
     */
    var street: String

    /**
     * The user's house number.
     */
    var number: Int

    /**
     * The user's zip code.
     */
    var zipCode: Int

    /**
     * The user's address complement.
     */
    var complement: String

    /**
     * The user's neighborhood.
     */
    var neighborhood: String

    /**
     * The user's city.
     */
    var city: String

    /**
     * The user's state.
     */
    var state: String

    /**
     * The maximum distance from the user's address.
     */
    var maximumDistanceMap: Double

    /**
     * Updates the value of the "street" field.
     *
     * @param street The new value of the "street" field.
     */
    fun onStreetChange(street: String)

    /**
     * Updates the value of the "number" field.
     *
     * @param number The new value of the "number" field.
     */
    fun onNumberChange(number: Int)

    /**
     * Updates the value of the "zipCode" field.
     *
     * @param zipCode The new value of the "zipCode" field.
     */
    fun onZipCodeChange(zipCode: Int)

    /**
     * Updates the value of the "complement" field.
     *
     * @param complement The new value of the "complement" field.
     */
    fun onComplementChange(complement: String)

    /**
     * Updates the value of the "neighborhood" field.
     *
     * @param neighborhood The new value of the "neighborhood" field.
     */
    fun onNeighborhoodChange(neighborhood: String)

    /**
     * Updates the value of the "city" field.
     *
     * @param city The new value of the "city" field.
     */
    fun onCityChange(city: String)

    /**
     * Updates the value of the "state" field.
     *
     * @param state The new value of the "state" field.
     */
    fun onStateChange(state: String)

    /**
     * Updates the value of the "maximumDistanceMap" field.
     *
     * @param maximumDistanceMap The new value of the "maximumDistanceMap" field.
     */
    fun onMaximumDistanceMapChange(maximumDistanceMap: Double)

    /**
     * Returns whether the ViewModel is currently loading data.
     *
     * @return true if the ViewModel is currently loading data, false otherwise.
     */
    fun isLoading(): Boolean

    /**
     * Validates the address data entered by the user.
     *
     * This function checks whether all the input fields on the address data screen have been filled out.
     *
     * @return true if all the input fields have been filled out, false otherwise.
     */
    fun validateAddressData(): Boolean

    /**
     * Clears the error state of the ViewModel.
     *
     * This function should be called when the user has acknowledged an error message, to remove the error message from the UI.
     */
    fun clearError()

    /**
     * Saves the address data entered by the user.
     *
     * This function should be called when the user clicks the "Save" button on the address data screen.
     */
    fun saveAddressData()
}