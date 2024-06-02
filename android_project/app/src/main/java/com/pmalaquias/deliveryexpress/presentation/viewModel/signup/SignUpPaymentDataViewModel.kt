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
class SignUpPaymentDataViewModel: ViewModel(){

    private val _uiState = MutableStateFlow(SignupPaymentDataUiState())
    val uiState: StateFlow<SignupPaymentDataUiState> = _uiState.asStateFlow()

    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var phone by mutableStateOf("")
    var address by mutableStateOf("")
    var city by mutableStateOf("")
    var state by mutableStateOf("")
    var zipCode by mutableIntStateOf(0)
    var country by mutableStateOf("")
    var cardNumber by mutableIntStateOf(0)
    var cardExpiration by mutableStateOf(Date())
    var cardCvv by mutableIntStateOf(0)
    var cardBrand by mutableStateOf("")
    var cardHolderName by mutableStateOf("")
    var cardHolderPhone by mutableIntStateOf(0)
    var cardHolderEmail by mutableStateOf("")
    var cardHolderAddress by mutableStateOf("")
    var cardHolderCity by mutableStateOf("")
    var cardHolderState by mutableStateOf("")
    var cardHolderZipCode by mutableIntStateOf(0)
    var cardHolderCountry by mutableStateOf("")
    var acceptTermsAndConditions by mutableStateOf(false)
    var cardHolderIsSameAsDeliveryPerson by mutableStateOf(false)
    var accountNumber by mutableIntStateOf(0)
    var accountType by mutableStateOf("")
    var bankName by mutableStateOf("")
    var bankBranch by mutableStateOf("")
    var isDataValid by mutableStateOf(false)
    var isLoading by mutableStateOf(false)
    var isError by mutableStateOf(false)

    // The following functions are used to update the mutable states.
    // Each function takes a parameter and assigns it to the corresponding mutable state.
    // For example, onNameChange(name: String) updates the 'name' mutable state.

    fun onNameChange(name: String){
        this.name = name
    }

    fun onEmailChange(email: String){
        this.email = email
    }

    fun onPhoneChange(phone: String){
        this.phone = phone
    }

    fun onAddressChange(address: String){
        this.address = address
    }

    fun onCityChange(city: String){
        this.city = city
    }

    fun onStateChange(state: String){
        this.state = state
    }

    fun onZipCodeChange(zipCode: Int){
        this.zipCode = zipCode
    }

    fun onCountryChange(country: String){
        this.country = country
    }

    fun onCardNumberChange(cardNumber: Int){
        this.cardNumber = cardNumber
    }

    fun onCardExpirationChange(cardExpiration: Date){
        this.cardExpiration = cardExpiration
    }

    fun onCardCvvChange(cardCvv: Int){
        this.cardCvv = cardCvv
    }


    fun onCardBrandChange(cardBrand: String){
        this.cardBrand = cardBrand
    }

    fun onCardHolderNameChange(cardHolderName: String){
        this.cardHolderName = cardHolderName
    }

    fun onCardHolderPhoneChange(cardHolderPhone: Int){
        this.cardHolderPhone = cardHolderPhone
    }

    fun onCardHolderEmailChange(cardHolderEmail: String){
        this.cardHolderEmail = cardHolderEmail
    }

    fun onCardHolderAddressChange(cardHolderAddress: String){
        this.cardHolderAddress = cardHolderAddress
    }

    fun onCardHolderCityChange(cardHolderCity: String){
        this.cardHolderCity = cardHolderCity
    }

    fun onCardHolderStateChange(cardHolderState: String){
        this.cardHolderState = cardHolderState
    }

    fun onCardHolderZipCodeChange(cardHolderZipCode: Int){
        this.cardHolderZipCode = cardHolderZipCode
    }

    fun onCardHolderCountryChange(cardHolderCountry: String){
        this.cardHolderCountry = cardHolderCountry

    }

    fun onAcceptTermsAndConditionsChange(acceptTermsAndConditions: Boolean){
        this.acceptTermsAndConditions = acceptTermsAndConditions
    }

    fun onCardHolderIsSameAsDeliveryPersonChange(cardHolderIsSameAsDeliveryPerson: Boolean){
        this.cardHolderIsSameAsDeliveryPerson = cardHolderIsSameAsDeliveryPerson
    }

    fun onAccountNumberChange(accountNumber: Int){
        this.accountNumber = accountNumber
    }

    fun onAccountTypeChange(accountType: String){
        this.accountType = accountType
    }

    fun onBankNameChange(bankName: String){
        this.bankName = bankName
    }

    fun onBankBranchChange(bankBranch: String){
        this.bankBranch = bankBranch
    }

    fun onIsDataValidChange(isDataValid: Boolean){
        this.isDataValid = isDataValid
    }

    fun onLoadingChange(isLoading: Boolean){
        this.isLoading = isLoading
    }

    fun onErrorChange(isError: Boolean){
        this.isError = isError
    }

    /**
     * Resets all the states to their default values.
     */
    fun reset(){
        name = ""
        email = ""
        phone = ""
        address = ""
        city = ""
        state = ""
        zipCode = 0
        country = ""
        cardNumber = 0
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