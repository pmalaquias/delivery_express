package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState.SignupDeliveryDataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel class for the SignUpDeliveryData screen.
 *
 * @property _uiState Private MutableStateFlow of SignupDeliveryDataUiState. Default value is an instance of SignupDeliveryDataUiState.
 * @property uiState Public StateFlow of SignupDeliveryDataUiState. It's a state flow version of _uiState.
 * @property deliveryType Mutable state of the delivery type input field. Default value is an empty string.
 * @property isLoading Mutable state of the loading state. Default value is false.
 */
class SignUpDeliveryDataViewModel : ViewModel(){

    private  val _uiState = MutableStateFlow(SignupDeliveryDataUiState())
    val uiState: StateFlow<SignupDeliveryDataUiState> = _uiState.asStateFlow()

    var deliveryType by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    /**
     * Updates the delivery type state.
     *
     * @param deliveryType The new value for the delivery type state.
     */
    fun onDeliveryTypeChange(deliveryType: String){
        this.deliveryType = deliveryType
    }

    /**
     * Updates the loading state.
     *
     * @param isLoading The new value for the loading state.
     */
    fun onLoadingChange(isLoading: Boolean){
        this.isLoading = isLoading
    }

    /**
     * Resets all the states to their default values.
     */
    fun reset(){
        deliveryType = ""
        isLoading = false
    }

}