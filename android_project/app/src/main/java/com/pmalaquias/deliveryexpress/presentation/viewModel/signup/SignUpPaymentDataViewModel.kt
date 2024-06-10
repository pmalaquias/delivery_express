package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState.SignupPaymentDataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Date

/**
 * ViewModel class for the SignUpPaymentData screen.
 *
 * @property _uiState Private MutableStateFlow of SignupPaymentDataUiState. Default value is an instance of SignupPaymentDataUiState.
 * @property uiState Public StateFlow of SignupPaymentDataUiState. It's a state flow version of _uiState.
 * @property name Mutable state of the name input field. Default value is an empty string.
 * @property email Mutable state of the email input field. Default value is an empty string.
 * @property phone Mutable state of the phone input field. Default value is an empty string.
 * @property address Mutable state of the address input field. Default value is an empty string.
 * @property city Mutable state of the city input field. Default value is an empty string.
 * @property state Mutable state of the state input field. Default value is an empty string.
 * @property zipCode Mutable state of the zip code input field. Default value is 0.
 * @property country Mutable state of the country input field. Default value is an empty string.
 * @property cardNumber Mutable state of the card number input field. Default value is 0.
 * @property cardExpiration Mutable state of the card expiration input field. Default value is the current date.
 * @property cardCvv Mutable state of the card CVV input field. Default value is 0.
 * @property cardBrand Mutable state of the card brand input field. Default value is an empty string.
 * @property cardHolderName Mutable state of the card holder's name input field. Default value is an empty string.
 * @property cardHolderPhone Mutable state of the card holder's phone input field. Default value is 0.
 * @property cardHolderEmail Mutable state of the card holder's email input field. Default value is an empty string.
 * @property cardHolderAddress Mutable state of the card holder's address input field. Default value is an empty string.
 * @property cardHolderCity Mutable state of the card holder's city input field. Default value is an empty string.
 * @property cardHolderState Mutable state of the card holder's state input field. Default value is an empty string.
 * @property cardHolderZipCode Mutable state of the card holder's zip code input field. Default value is 0.
 * @property cardHolderCountry Mutable state of the card holder's country input field. Default value is an empty string.
 * @property acceptTermsAndConditions Mutable state of the accept terms and conditions checkbox. Default value is false.
 * @property cardHolderIsSameAsDeliveryPerson Mutable state of the card holder is same as delivery person checkbox. Default value is false.
 * @property accountNumber Mutable state of the account number input field. Default value is 0.
 * @property accountType Mutable state of the account type input field. Default value is an empty string.
 * @property bankName Mutable state of the bank name input field. Default value is an empty string.
 * @property bankBranch Mutable state of the bank branch input field. Default value is an empty string.
 * @property isDataValid Mutable state of the data validation state. Default value is false.
 * @property isLoading Mutable state of the loading state. Default value is false.
 * @property isError Mutable state of the error state. Default value is false.
 */
class SignUpPaymentDataViewModel : ViewModel() {

    // MutableStateFlow for the UI state of the SignUpPaymentData screen.
    private val _uiState = MutableStateFlow(SignupPaymentDataUiState())

    // Public StateFlow for the UI state of the SignUpPaymentData screen.
    val uiState: StateFlow<SignupPaymentDataUiState> = _uiState.asStateFlow()

    // Mutable state for the name input field.
    var name by mutableStateOf("")

    // Mutable state for the email input field.
    var email by mutableStateOf("")

    // Mutable state for the phone input field.
    var phone by mutableStateOf("")

    // Mutable state for the address input field.
    var address by mutableStateOf("")

    // Mutable state for the city input field.
    var city by mutableStateOf("")

    // Mutable state for the state input field.
    var state by mutableStateOf("")

    // Mutable state for the zip code input field.
    var zipCode by mutableIntStateOf(0)

    // Mutable state for the country input field.
    var country by mutableStateOf("")

    // Mutable state for the card number input field.
    var cardNumber by mutableStateOf("")

    // Mutable state for the card expiration input field.
    var cardExpiration by mutableStateOf(Date())

    // Mutable state for the card CVV input field.
    var cardCvv by mutableIntStateOf(0)

    // Mutable state for the card brand input field.
    var cardBrand by mutableStateOf("")

    // Mutable state for the card holder's name input field.
    var cardHolderName by mutableStateOf("")

    // Mutable state for the card holder's phone input field.
    var cardHolderPhone by mutableIntStateOf(0)

    // Mutable state for the card holder's email input field.
    var cardHolderEmail by mutableStateOf("")

    // Mutable state for the card holder's address input field.
    var cardHolderAddress by mutableStateOf("")

    // Mutable state for the card holder's city input field.
    var cardHolderCity by mutableStateOf("")

    // Mutable state for the card holder's state input field.
    var cardHolderState by mutableStateOf("")

    // Mutable state for the card holder's zip code input field.
    var cardHolderZipCode by mutableIntStateOf(0)

    // Mutable state for the card holder's country input field.
    var cardHolderCountry by mutableStateOf("")

    // Mutable state for the accept terms and conditions checkbox.
    var acceptTermsAndConditions by mutableStateOf(false)

    // Mutable state for the card holder is same as delivery person checkbox.
    var cardHolderIsSameAsDeliveryPerson by mutableStateOf(false)

    // Mutable state for the account number input field.
    var accountNumber by mutableIntStateOf(0)

    // Mutable state for the account type input field.
    var accountType by mutableStateOf("")

    // Mutable state for the bank name input field.
    var bankName by mutableStateOf("")

    // Mutable state for the bank branch input field.
    var bankBranch by mutableStateOf("")

    // Mutable state for the data validation state.
    var isDataValid by mutableStateOf(false)

    // Mutable state for the loading state.
    var isLoading by mutableStateOf(false)

    // Mutable state for the error state.
    var isError by mutableStateOf(false)

    // The following functions are used to update the mutable states.
    // Each function takes a parameter and assigns it to the corresponding mutable state.
    // For example, onNameChange(name: String) updates the 'name' mutable state.

    /**
     * Updates the name state.
     *
     * @param name The new name.
     */
    fun onNameChange(name: String) {
        this.name = name
    }

    /**
     * Updates the email state.
     *
     * @param email The new email.
     */
    fun onEmailChange(email: String) {
        this.email = email
    }

    /**
     * Updates the phone state.
     *
     * @param phone The new phone.
     */
    fun onPhoneChange(phone: String) {
        this.phone = phone
    }

    /**
     * Updates the address state.
     *
     * @param address The new address.
     */
    fun onAddressChange(address: String) {
        this.address = address
    }

    /**
     * Updates the city state.
     *
     * @param city The new city.
     */
    fun onCityChange(city: String) {
        this.city = city
    }

    /**
     * Updates the state state.
     *
     * @param state The new state.
     */
    fun onStateChange(state: String) {
        this.state = state
    }

    /**
     * Updates the zipCode state.
     *
     * @param zipCode The new zipCode.
     */
    fun onZipCodeChange(zipCode: Int) {
        this.zipCode = zipCode
    }

    /**
     * Updates the country state.
     *
     * @param country The new country.
     */
    fun onCountryChange(country: String) {
        this.country = country
    }

    /**
     * Updates the cardNumber state.
     *
     * @param cardNumber The new cardNumber.
     */
    fun onCardNumberChange(cardNumber: String) {
        println("cardNumber: $cardNumber")
        this.cardNumber = cardNumber
    }

    /**
     * Updates the cardExpiration state.
     *
     * @param cardExpiration The new cardExpiration.
     */
    fun onCardExpirationChange(cardExpiration: Date) {
        println("cardExpiration: $cardExpiration")
        this.cardExpiration = cardExpiration
    }

    /**
     * Updates the cardCvv state.
     *
     * @param cardCvv The new cardCvv.
     */
    fun onCardCvvChange(cardCvv: Int) {
        this.cardCvv = cardCvv
    }

    /**
     * Updates the cardBrand state.
     *
     * @param cardBrand The new cardBrand.
     */
    fun onCardBrandChange(cardBrand: String) {
        println("cardBrand: $cardBrand")
        this.cardBrand = cardBrand
    }

    /**
     * Updates the cardHolderName state.
     *
     * @param cardHolderName The new cardHolderName.
     */
    fun onCardHolderNameChange(cardHolderName: String) {
        this.cardHolderName = cardHolderName
    }

    /**
     * Updates the cardHolderPhone state.
     *
     * @param cardHolderPhone The new cardHolderPhone.
     */
    fun onCardHolderPhoneChange(cardHolderPhone: Int) {
        this.cardHolderPhone = cardHolderPhone
    }

    /**
     * Updates the cardHolderEmail state.
     *
     * @param cardHolderEmail The new cardHolderEmail.
     */
    fun onCardHolderEmailChange(cardHolderEmail: String) {
        this.cardHolderEmail = cardHolderEmail
    }

    /**
     * Updates the cardHolderAddress state.
     *
     * @param cardHolderAddress The new cardHolderAddress.
     */
    fun onCardHolderAddressChange(cardHolderAddress: String) {
        this.cardHolderAddress = cardHolderAddress
    }

    /**
     * Updates the cardHolderCity state.
     *
     * @param cardHolderCity The new cardHolderCity.
     */
    fun onCardHolderCityChange(cardHolderCity: String) {
        this.cardHolderCity = cardHolderCity
    }

    /**
     * Updates the cardHolderState state.
     *
     * @param cardHolderState The new cardHolderState.
     */
    fun onCardHolderStateChange(cardHolderState: String) {
        this.cardHolderState = cardHolderState
    }

    /**
     * Updates the cardHolderZipCode state.
     *
     * @param cardHolderZipCode The new cardHolderZipCode.
     */
    fun onCardHolderZipCodeChange(cardHolderZipCode: Int) {
        this.cardHolderZipCode = cardHolderZipCode
    }

    /**
     * Updates the cardHolderCountry state.
     *
     * @param cardHolderCountry The new cardHolderCountry.
     */
    fun onCardHolderCountryChange(cardHolderCountry: String) {
        this.cardHolderCountry = cardHolderCountry
    }

    /**
     * Updates the acceptTermsAndConditions state.
     *
     * @param acceptTermsAndConditions The new acceptTermsAndConditions.
     */
    fun onAcceptTermsAndConditionsChange(acceptTermsAndConditions: Boolean) {
        println("acceptTermsAndConditions: $acceptTermsAndConditions")
        this.acceptTermsAndConditions = acceptTermsAndConditions
    }

    /**
     * Updates the cardHolderIsSameAsDeliveryPerson state.
     *
     * @param cardHolderIsSameAsDeliveryPerson The new cardHolderIsSameAsDeliveryPerson.
     */
    fun onCardHolderIsSameAsDeliveryPersonChange(cardHolderIsSameAsDeliveryPerson: Boolean) {
        println("cardHolderIsSameAsDeliveryPerson: $cardHolderIsSameAsDeliveryPerson")
        this.cardHolderIsSameAsDeliveryPerson = cardHolderIsSameAsDeliveryPerson
    }

    /**
     * Updates the accountNumber state.
     *
     * @param accountNumber The new accountNumber.
     */
    fun onAccountNumberChange(accountNumber: Int) {
        this.accountNumber = accountNumber
    }

    /**
     * Updates the accountType state.
     *
     * @param accountType The new accountType.
     */
    fun onAccountTypeChange(accountType: String) {
        this.accountType = accountType
    }

    /**
     * Updates the bankName state.
     *
     * @param bankName The new bankName.
     */
    fun onBankNameChange(bankName: String) {
        this.bankName = bankName
    }

    /**
     * Updates the bankBranch state.
     *
     * @param bankBranch The new bankBranch.
     */
    fun onBankBranchChange(bankBranch: String) {
        this.bankBranch = bankBranch
    }

    /**
     * Updates the isDataValid state.
     *
     * @param isDataValid The new isDataValid.
     */
    fun onIsDataValidChange(isDataValid: Boolean) {
        this.isDataValid = isDataValid
    }

    /**
     * Updates the isLoading state.
     *
     * @param isLoading The new isLoading.
     */
    fun onLoadingChange(isLoading: Boolean) {
        this.isLoading = isLoading
    }

    /**
     * Updates the isError state.
     *
     * @param isError The new isError.
     */
    fun onErrorChange(isError: Boolean) {
        this.isError = isError
    }

    /**
     * Resets all the states to their default values.
     */
    fun reset() {
        name = ""
        email = ""
        phone = ""
        address = ""
        city = ""
        state = ""
        zipCode = 0
        country = ""
        cardNumber = ""
        cardExpiration = Date()
        cardCvv = 0
        cardBrand = "null"
        cardHolderName = ""
        cardHolderPhone = 0
        cardHolderEmail = ""
        cardHolderAddress = ""
        cardHolderCity = ""
        cardHolderState = ""
        cardHolderZipCode = 0
        cardHolderCountry = ""
        acceptTermsAndConditions = false
        cardHolderIsSameAsDeliveryPerson = false
        accountNumber = 0
        accountType = ""
        bankName = ""
        bankBranch = ""
        isDataValid = false
        isLoading = false
        isError = false
    }

}