package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

/**
 * An interface that defines the properties and methods for managing access data in a ViewModel.
 *
 * This interface is designed to be implemented by ViewModel classes that need to handle user access data, such as email and password.
 */
interface IAccessDataViewModel {

    /**
     * The user's email.
     */
    var email: String

    /**
     * The user's confirmed email.
     */
    var confirmEmail: String

    /**
     * The user's password.
     */
    var password: String

    /**
     * The user's confirmed password.
     */
    var confirmPassword: String

    /**
     * Updates the value of the "email" field.
     *
     * @param email The new value of the "email" field.
     */
    fun onEmailChange(email: String)

    /**
     * Updates the value of the "confirmEmail" field.
     *
     * @param confirmEmail The new value of the "confirmEmail" field.
     */
    fun onConfirmEmailChange(confirmEmail: String)

    /**
     * Updates the value of the "password" field.
     *
     * @param password The new value of the "password" field.
     */
    fun onPasswordChange(password: String)

    /**
     * Updates the value of the "confirmPassword" field.
     *
     * @param confirmPassword The new value of the "confirmPassword" field.
     */
    fun onConfirmPasswordChange(confirmPassword: String)

    /**
     * Returns whether the ViewModel is currently loading data.
     *
     * @return true if the ViewModel is currently loading data, false otherwise.
     */
    fun isLoading(): Boolean

    /**
     * Validates the access data entered by the user.
     *
     * This function checks whether all the input fields on the access data screen have been filled out.
     *
     * @return true if all the input fields have been filled out, false otherwise.
     */
    fun validateAccessData(): Boolean

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
     * Saves the access data entered by the user.
     *
     * This function should be called when the user clicks the "Save" button on the access data screen.
     */
    fun saveAccessData()
}