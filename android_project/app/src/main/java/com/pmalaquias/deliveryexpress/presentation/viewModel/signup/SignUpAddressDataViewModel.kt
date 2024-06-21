package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState.SignupAddressDataUiState
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces.IAddressDataViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel class for the SignUpAddressData screen.
 *
 * @property _uiState Private MutableStateFlow of SignupAddressDataUiState. Default value is an instance of SignupAddressDataUiState.
 * @property uiState Public StateFlow of SignupAddressDataUiState. It's a state flow version of _uiState.
 * @property street Mutable state of the street input field. Default value is an empty string.
 * @property number Mutable state of the number input field. Default value is 0.
 * @property zipCode Mutable state of the zip code input field. Default value is 0.
 * @property complement Mutable state of the complement input field. Default value is an empty string.
 * @property neighborhood Mutable state of the neighborhood input field. Default value is an empty string.
 * @property city Mutable state of the city input field. Default value is an empty string.
 * @property state Mutable state of the state input field. Default value is an empty string.
 * @property maximumDistanceMap Mutable state of the maximum distance map input field. Default value is 0.0.
 * @property isLoading Mutable state of the loading state. Default value is false.
 */
class SignUpAddressDataViewModel : ViewModel(), IAddressDataViewModel {

    private val _uiState = MutableStateFlow(SignupAddressDataUiState())
    val uiState: StateFlow<SignupAddressDataUiState> = _uiState.asStateFlow()

    override var street by mutableStateOf("")
    override var number by mutableIntStateOf(0)
    override var zipCode by mutableIntStateOf(0)
    override var complement by mutableStateOf("")
    override var neighborhood by mutableStateOf("")
    override var city by mutableStateOf("")
    override var state by mutableStateOf("")
    override var maximumDistanceMap by mutableDoubleStateOf(0.0)
    //var isLoading by mutableStateOf(false)

    /**
     * Updates the street state.
     *
     * @param street The new value for the street state.
     */
    override fun onStreetChange(street: String) {
        this.street = street
    }

    /**
     * Updates the number state.
     *
     * @param number The new value for the number state.
     */
    override fun onNumberChange(number: Int) {
        this.number = number
    }

    /**
     * Updates the zip code state.
     *
     * @param zipCode The new value for the zip code state.
     */
    override fun onZipCodeChange(zipCode: Int) {
        this.zipCode = zipCode
    }

    /**
     * Updates the complement state.
     *
     * @param complement The new value for the complement state.
     */
    override fun onComplementChange(complement: String) {
        this.complement = complement
    }

    /**
     * Updates the neighborhood state.
     *
     * @param neighborhood The new value for the neighborhood state.
     */
    override fun onNeighborhoodChange(neighborhood: String) {
        this.neighborhood = neighborhood
    }

    /**
     * Updates the city state.
     *
     * @param city The new value for the city state.
     */
    override fun onCityChange(city: String) {
        this.city = city
    }

    /**
     * Updates the state state.
     *
     * @param state The new value for the state state.
     */
    override fun onStateChange(state: String) {
        this.state = state
    }

    /**
     * Updates the maximum distance map state.
     *
     * @param maximumDistanceMap The new value for the maximum distance map state.
     */
    override fun onMaximumDistanceMapChange(maximumDistanceMap: Double) {
        this.maximumDistanceMap = maximumDistanceMap
    }

    override fun isLoading(): Boolean {
        TODO("Not yet implemented")
    }

    override fun validateAddressData(): Boolean {
        TODO("Not yet implemented")
    }

    override fun clearError() {
        TODO("Not yet implemented")
    }

    override fun saveAddressData() {
        TODO("Not yet implemented")
    }

    /**
     * Updates the loading state.
     *
     * @param isLoading The new value for the loading state.
     */
    fun onLoadingChange(isLoading: Boolean) {
        //this.isLoading = isLoading
    }

    /**
     * Resets all the states to their default values.
     */
    fun reset() {
        street = ""
        number = 0
        zipCode = 0
        complement = ""
        neighborhood = ""
        city = ""
        state = ""
        maximumDistanceMap = 0.0
        //isLoading = false
    }

}