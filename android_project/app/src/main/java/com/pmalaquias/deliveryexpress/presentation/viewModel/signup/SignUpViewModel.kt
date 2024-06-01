package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignupPersonalDataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the SignupDeliveryPersonPersonalData screen.
 *
 * This ViewModel manages the UI state for the SignupDeliveryPersonPersonalData screen and handles user interactions.
 */

class SignupDeliveryPersonPersonalDataViewModel : ViewModel() {

    // The UI state for the SignupDeliveryPersonPersonalData screen.
    private val _uiState = MutableStateFlow(SignupPersonalDataUiState())
    val uiState: StateFlow<SignupPersonalDataUiState> = _uiState.asStateFlow()

    // The current values of the input fields on the SignupDeliveryPersonPersonalData screen.
    var name by mutableStateOf("")
    var birthDate by mutableStateOf("")
    var id by mutableStateOf("")
    var phone by mutableStateOf("")
    var photo by mutableStateOf("")

    /**
     * Saves the personal data entered by the user.
     *
     * This function should be called when the user clicks the "Save" button on the SignupDeliveryPersonPersonalData screen.
     * It launches a coroutine in the ViewModel's scope, where the authentication logic should be implemented.
     */
    fun savePersonalData() {
        viewModelScope.launch {
            // Implement authentication logic here (use repository)
            // If login is successful, update UI state
            // If login fails, update error state
        }
    }

    /**
     * Updates the value of the "name" field.
     *
     * @param name The new value of the "name" field.
     */
    fun onNameChange(name: String) {
        this.name = name
    }

    /**
     * Updates the value of the "birthDate" field.
     *
     * @param birthDate The new value of the "birthDate" field.
     */
    fun onBirthDateChange(birthDate: String) {
        this.birthDate = birthDate
    }

    /**
     * Updates the value of the "id" field.
     *
     * @param id The new value of the "id" field.
     */
    fun onIdChange(id: String) {
        this.id = id
    }

    /**
     * Updates the value of the "phone" field.
     *
     * @param phone The new value of the "phone" field.
     */
    fun onPhoneChange(phone: String) {
        this.phone = phone
    }

    /**
     * Updates the value of the "photo" field.
     *
     * @param photo The new value of the "photo" field.
     */
    fun onPhotoChange(photo: String) {
        this.photo = photo
    }

    /**
     * Returns whether the ViewModel is currently loading data.
     *
     * @return true if the ViewModel is currently loading data, false otherwise.
     */
    fun isLoading(): Boolean {
        return true
    }

    /**
     * Validates the personal data entered by the user.
     *
     * This function checks whether all the input fields on the SignupDeliveryPersonPersonalData screen have been filled out.
     *
     * @return true if all the input fields have been filled out, false otherwise.
     */
    fun validatePersonalData(): Boolean {
        return name.isNotEmpty() && birthDate.isNotEmpty() && id.isNotEmpty() && phone.isNotEmpty() && photo.isNotEmpty()
    }

    /**
     * Clears the error state of the ViewModel.
     *
     * This function should be called when the user has acknowledged an error message, to remove the error message from the UI.
     */
    fun clearError() {
        var loginError = null
    }

}

/**
 * ViewModel for the SignupClientPersonalData screen.
 *
 * This ViewModel manages the UI state for the SignupClientPersonalData screen and handles user interactions.
 * It holds the current values of the input fields on the SignupClientPersonalData screen.
 * It also provides functions to update these values, save the personal data, validate the personal data, and clear the error state.
 */
class SignupClientPersonalDataViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignupPersonalDataUiState())
    val uiState: StateFlow<SignupPersonalDataUiState> = _uiState.asStateFlow()

    // UI state
    var name by mutableStateOf("")
    var commercialName by mutableStateOf("")
    var birthDate by mutableStateOf("")
    var id by mutableStateOf("")
    var phone by mutableStateOf("")
    var photo by mutableStateOf("")
    //var isLoading by mutableStateOf(false)

    /**
     * Saves the personal data entered by the user.
     *
     * This function should be called when the user clicks the "Save" button on the SignupClientPersonalData screen.
     * It launches a coroutine in the ViewModel's scope, where the authentication logic should be implemented.
     */
    fun savePersonalData() {
        //isLoading = true

        viewModelScope.launch {
            // Implement authentication logic here (use repository)
            // If login is successful, update UI state
            // If login fails, update error state

            //isLoading = false
        }
    }

    /**
     * Updates the value of the "name" field.
     *
     * @param name The new value of the "name" field.
     */
    fun onNameChange(name: String) {
        this.name = name
    }

    /**
     * Updates the value of the "commercialName" field.
     *
     * @param commercialName The new value of the "commercialName" field.
     */
    fun onCommercialNameChange(commercialName: String) {
        this.commercialName = commercialName
    }

    /**
     * Updates the value of the "birthDate" field.
     *
     * @param birthDate The new value of the "birthDate" field.
     */
    fun onBirthDateChange(birthDate: String) {
        this.birthDate = birthDate
    }

    /**
     * Updates the value of the "id" field.
     *
     * @param id The new value of the "id" field.
     */
    fun onIdChange(id: String) {
        this.id = id
    }

    /**
     * Updates the value of the "phone" field.
     *
     * @param phone The new value of the "phone" field.
     */
    fun onPhoneChange(phone: String) {
        this.phone = phone
    }

    /**
     * Updates the value of the "photo" field.
     *
     * @param photo The new value of the "photo" field.
     */
    fun onPhotoChange(photo: String) {
        this.photo = photo
    }

    /**
     * Returns whether the ViewModel is currently loading data.
     *
     * @return true if the ViewModel is currently loading data, false otherwise.
     */
    fun isLoading(): Boolean {
        //return isLoading
        return true
    }

    /**
     * Validates the personal data entered by the user.
     *
     * This function checks whether all the input fields on the SignupClientPersonalData screen have been filled out.
     *
     * @return true if all the input fields have been filled out, false otherwise.
     */
    fun validatePersonalData(): Boolean {
        return name.isNotEmpty() && birthDate.isNotEmpty() && id.isNotEmpty() && phone.isNotEmpty() && photo.isNotEmpty()
    }

    /**
     * Clears the error state of the ViewModel.
     *
     * This function should be called when the user has acknowledged an error message, to remove the error message from the UI.
     */
    fun clearError() {
        var loginError = null
    }

}