package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignupPersonalDataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignupPersonalDataViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignupPersonalDataUiState())
    val uiState: StateFlow<SignupPersonalDataUiState> = _uiState.asStateFlow()

    // UI state
     var name by mutableStateOf("")
     var birthDate by mutableStateOf("")
     var id by mutableIntStateOf(0)
     var phone by mutableIntStateOf(0)
     var photo by mutableStateOf("")
     //var isLoading by mutableStateOf(false)

    // Function to perform login
    fun savePersonalData() {
        //isLoading = true

        viewModelScope.launch {
            // Implement authentication logic here (use repository)
            // If login is successful, update UI state
            // If login fails, update error state

            //isLoading = false
        }
    }

    // Function to handle name change
    fun onNameChange(name: String) {
        this.name = name
    }

    // Function to handle birth date change
    fun onBirthDateChange(birthDate: String) {
        this.birthDate = birthDate
    }

    // Function to handle CPF change
    fun onIdChange(id: Int) {
        this.id = id
    }

    // Function to handle phone change
    fun onPhoneChange(phone: Int) {
        this.phone = phone
    }

    // Function to handle photo change
    fun onPhotoChange(photo: String) {
        this.photo = photo
    }

    // Function to handle loading state
    fun isLoading(): Boolean {
        //return isLoading
        return true
    }

    fun validatePersonalData(): Boolean {
        return name.isNotEmpty() && birthDate.isNotEmpty() && id != 0 && phone != 0
    }

    // Function to clear error state
    fun clearError() {
        var loginError = null
    }

}