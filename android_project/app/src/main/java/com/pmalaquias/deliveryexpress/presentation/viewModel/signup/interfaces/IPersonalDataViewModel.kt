package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

/**
 * An interface that defines the properties and methods for managing personal data in a ViewModel.
 *
 * This interface is designed to be implemented by ViewModel classes that need to handle user personal data, such as name, birth date, id, phone, and photo path.
 */
interface IPersonalDataViewModel {

    /**
     * The user's name.
     */
    var name: String

    /**
     * The user's commercial name.
     */
    var commercialName: String

    /**
     * The user's birth date.
     */
    var birthDate: String

    /**
     * The user's id.
     */
    var id: String

    /**
     * The user's phone.
     */
    var phone: String

    /**
     * The user's photo path.
     */
    var photoPath: String

    /**
     * Saves the personal data entered by the user.
     *
     * This function should be called when the user clicks the "Save" button on the personal data screen.
     */
    fun savePersonalData()

    /**
     * Updates the value of the "name" field.
     *
     * @param name The new value of the "name" field.
     */
    fun onNameChange(name: String)

    /**
     * Updates the value of the "commercialName" field.
     *
     * @param commercialName The new value of the "commercialName" field.
     */
    fun onCommercialNameChange(commercialName: String)

    /**
     * Updates the value of the "birthDate" field.
     *
     * @param birthDate The new value of the "birthDate" field.
     */
    fun onBirthDateChange(birthDate: String)

    /**
     * Updates the value of the "id" field.
     *
     * @param id The new value of the "id" field.
     */
    fun onIdChange(id: String)

    /**
     * Updates the value of the "phone" field.
     *
     * @param phone The new value of the "phone" field.
     */
    fun onPhoneChange(phone: String)

    /**
     * Updates the value of the "photoPath" field.
     *
     * @param photoPath The new value of the "photoPath" field.
     */
    fun onPhotoChange(photoPath: String)

    /**
     * Returns whether the ViewModel is currently loading data.
     *
     * @return true if the ViewModel is currently loading data, false otherwise.
     */
    fun isLoading(): Boolean

    /**
     * Validates the personal data entered by the user.
     *
     * This function checks whether all the input fields on the personal data screen have been filled out.
     *
     * @return true if all the input fields have been filled out, false otherwise.
     */
    fun validatePersonalData(): Boolean

    /**
     * Clears the error state of the ViewModel.
     *
     * This function should be called when the user has acknowledged an error message, to remove the error message from the UI.
     */
    fun clearError()
}