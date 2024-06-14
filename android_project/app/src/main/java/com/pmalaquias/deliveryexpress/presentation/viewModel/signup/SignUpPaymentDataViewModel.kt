package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState.SignupPaymentDataUiState
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces.IPaymentDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces.IPersonalDataViewModel
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
class SignUpPaymentDataViewModel : ViewModel(), IPaymentDataViewModel {

    // MutableStateFlow for the UI state of the SignUpPaymentData screen.
    private val _uiState = MutableStateFlow(SignupPaymentDataUiState())

    // Public StateFlow for the UI state of the SignUpPaymentData screen.
    val uiState: StateFlow<SignupPaymentDataUiState> = _uiState.asStateFlow()

    // Mutable state for the name input field.
    override var name by mutableStateOf("")

    // Mutable state for the email input field.
    override var email by mutableStateOf("")

    // Mutable state for the phone input field.
    override var phone by mutableStateOf("")

    // Mutable state for the address input field.
    override var address by mutableStateOf("")

    // Mutable state for the city input field.
    override var city by mutableStateOf("")

    // Mutable state for the state input field.
    override var state by mutableStateOf("")

    // Mutable state for the zip code input field.
    override var zipCode by mutableIntStateOf(0)

    // Mutable state for the country input field.
    override var country by mutableStateOf("")

    override var agency by mutableStateOf("")

    // Mutable state for the card number input field.
    override var cardNumber by mutableStateOf("")

    // Mutable state for the card expiration input field.
    override var cardExpiration by mutableStateOf(Date())

    // Mutable state for the card CVV input field.
    override var cardCvv by mutableIntStateOf(0)

    // Mutable state for the card brand input field.
    override var cardBrand by mutableStateOf("")

    // Mutable state for the card holder's name input field.
    override var cardHolderName by mutableStateOf("")

    // Mutable state for the card holder's phone input field.
    override var cardHolderPhone by mutableStateOf("")

    // Mutable state for the card holder's email input field.
    override var cardHolderEmail by mutableStateOf("")

    // Mutable state for the card holder's address input field.
    override var cardHolderAddress by mutableStateOf("")

    // Mutable state for the card holder's city input field.
    override var cardHolderCity by mutableStateOf("")

    // Mutable state for the card holder's state input field.
    override var cardHolderState by mutableStateOf("")

    // Mutable state for the card holder's zip code input field.
    override var cardHolderZipCode by mutableStateOf("")

    // Mutable state for the card holder's country input field.
    override var cardHolderCountry by mutableStateOf("")

    // Mutable state for the accept terms and conditions checkbox.
    override var acceptTermsAndConditions by mutableStateOf(false)

    // Mutable state for the card holder is same as delivery person checkbox.
    override var cardHolderIsSameAsDeliveryPerson by mutableStateOf(false)

    // Mutable state for the account number input field.
    override var accountNumber: String by mutableStateOf("")

    // Mutable state for the account type input field.
    override var accountType by mutableStateOf("")

    // Mutable state for the bank name input field.
    override var bankName by mutableStateOf("")

    // Mutable state for the bank branch input field.
    override var bankBranch by mutableStateOf("")

    // Mutable state for the data validation state.
    override var isDataValid by mutableStateOf(false)

    // Mutable state for the loading state.
    override var isLoading by mutableStateOf(false)

    // Mutable state for the error state.
    override var isError by mutableStateOf(false)

    private fun copyUserDataToBankData(
        accessDataViewModel: SignUpAccessDataViewModel,
        addressDataViewModel: SignUpAddressDataViewModel,
        personalDataViewModel: IPersonalDataViewModel
    ) {
        println("name: ${personalDataViewModel.name}")
        cardHolderName = personalDataViewModel.name
    }

    // The following functions are used to update the mutable states.
    // Each function takes a parameter and assigns it to the corresponding mutable state.
    // For example, onNameChange(name: String) updates the 'name' mutable state.

    /**
     * Updates the name state.
     *
     * @param name The new name.
     */
    override fun onNameChange(name: String) {
        println("name: $name")
        this.name = name
    }

    /**
     * Updates the email state.
     *
     * @param email The new email.
     */
    override fun onEmailChange(email: String) {
        this.email = email
    }

    /**
     * Updates the phone state.
     *
     * @param phone The new phone.
     */
    override fun onPhoneChange(phone: String) {
        this.phone = phone
    }

    /**
     * Updates the address state.
     *
     * @param address The new address.
     */
    override fun onAddressChange(address: String) {
        this.address = address
    }

    /**
     * Updates the city state.
     *
     * @param city The new city.
     */
    override fun onCityChange(city: String) {
        this.city = city
    }

    /**
     * Updates the state state.
     *
     * @param state The new state.
     */
    override fun onStateChange(state: String) {
        this.state = state
    }

    /**
     * Updates the zipCode state.
     *
     * @param zipCode The new zipCode.
     */
    override fun onZipCodeChange(zipCode: Int) {
        this.zipCode = zipCode
    }

    /**
     * Updates the country state.
     *
     * @param country The new country.
     */
    override fun onCountryChange(country: String) {
        this.country = country
    }

    /**
     * Updates the cardNumber state.
     *
     * @param cardNumber The new cardNumber.
     */
    override fun onCardNumberChange(cardNumber: String) {
        println("cardNumber: $cardNumber")
        this.cardNumber = cardNumber
    }

    /**
     * Updates the cardExpiration state.
     *
     * @param cardExpiration The new cardExpiration.
     */
    override fun onCardExpirationChange(cardExpiration: Date) {
        println("cardExpiration: $cardExpiration")
        this.cardExpiration = cardExpiration
    }

    /**
     * Updates the cardCvv state.
     *
     * @param cardCvv The new cardCvv.
     */
    override fun onCardCvvChange(cardCvv: Int) {
        this.cardCvv = cardCvv
    }

    /**
     * Updates the cardBrand state.
     *
     * @param cardBrand The new cardBrand.
     */
    override fun onCardBrandChange(cardBrand: String) {
        println("cardBrand: $cardBrand")
        this.cardBrand = cardBrand
    }

    /**
     * Updates the cardHolderName state.
     *
     * @param cardHolderName The new cardHolderName.
     */
    override fun onCardHolderNameChange(cardHolderName: String) {
        this.cardHolderName = cardHolderName
    }

    /**
     * Updates the cardHolderPhone state.
     *
     * @param cardHolderPhone The new cardHolderPhone.
     */
    override fun onCardHolderPhoneChange(cardHolderPhone: String) {
        this.cardHolderPhone = cardHolderPhone
    }

    /**
     * Updates the cardHolderEmail state.
     *
     * @param cardHolderEmail The new cardHolderEmail.
     */
    override fun onCardHolderEmailChange(cardHolderEmail: String) {
        this.cardHolderEmail = cardHolderEmail
    }

    /**
     * Updates the cardHolderAddress state.
     *
     * @param cardHolderAddress The new cardHolderAddress.
     */
    override fun onCardHolderAddressChange(cardHolderAddress: String) {
        this.cardHolderAddress = cardHolderAddress
    }

    /**
     * Updates the cardHolderCity state.
     *
     * @param cardHolderCity The new cardHolderCity.
     */
    override fun onCardHolderCityChange(cardHolderCity: String) {
        this.cardHolderCity = cardHolderCity
    }

    /**
     * Updates the cardHolderState state.
     *
     * @param cardHolderState The new cardHolderState.
     */
    override fun onCardHolderStateChange(cardHolderState: String) {
        this.cardHolderState = cardHolderState
    }

    /**
     * Updates the cardHolderZipCode state.
     *
     * @param cardHolderZipCode The new cardHolderZipCode.
     */
    override fun onCardHolderZipCodeChange(cardHolderZipCode: String) {
        this.cardHolderZipCode = cardHolderZipCode
    }

    /**
     * Updates the cardHolderCountry state.
     *
     * @param cardHolderCountry The new cardHolderCountry.
     */
    override fun onCardHolderCountryChange(cardHolderCountry: String) {
        this.cardHolderCountry = cardHolderCountry
    }

    /**
     * Updates the acceptTermsAndConditions state.
     *
     * @param acceptTermsAndConditions The new acceptTermsAndConditions.
     */
    override fun onAcceptTermsAndConditionsChange(acceptTermsAndConditions: Boolean) {
        println("acceptTermsAndConditions: $acceptTermsAndConditions")
        this.acceptTermsAndConditions = acceptTermsAndConditions
    }

    /**
     * Updates the cardHolderIsSameAsDeliveryPerson state.
     *
     * @param cardHolderIsSameAsDeliveryPerson The new cardHolderIsSameAsDeliveryPerson.
     */
    override fun onCardHolderIsSameAsDeliveryPersonChange(cardHolderIsSameAsDeliveryPerson: Boolean) {
        println("cardHolderIsSameAsDeliveryPerson: $cardHolderIsSameAsDeliveryPerson")
        this.cardHolderIsSameAsDeliveryPerson = cardHolderIsSameAsDeliveryPerson
    }

    /**
     * Updates the accountNumber state.
     *
     * @param accountNumber The new accountNumber.
     */
    override fun onAccountNumberChange(accountNumber: String) {
        this.accountNumber = accountNumber
    }

    override fun onAgencyChange(agency: String) {
        TODO("Not yet implemented")
    }

    /**
     * Updates the accountType state.
     *
     * @param accountType The new accountType.
     */
    override fun onAccountTypeChange(accountType: String) {
        this.accountType = accountType
    }

    /**
     * Updates the bankName state.
     *
     * @param bankName The new bankName.
     */
    override fun onBankNameChange(bankName: String) {
        this.bankName = bankName
    }

    /**
     * Updates the bankBranch state.
     *
     * @param bankBranch The new bankBranch.
     */
    override fun onBankBranchChange(bankBranch: String) {
        this.bankBranch = bankBranch
    }

    /**
     * Updates the isDataValid state.
     *
     * @param isDataValid The new isDataValid.
     */
    override fun onIsDataValidChange(isDataValid: Boolean) {
        this.isDataValid = isDataValid
    }

    override fun clearError() {
        TODO("Not yet implemented")
    }

    override fun savePaymentData() {
        TODO("Not yet implemented")
    }

    /**
     * Updates the isLoading state.
     *
     * @param isLoading The new isLoading.
     */
    override fun onLoadingChange(isLoading: Boolean) {
        this.isLoading = isLoading
    }

    override fun onIsErrorChange(isError: Boolean) {
        TODO("Not yet implemented")
    }

    override fun validatePaymentData(): Boolean {
        TODO("Not yet implemented")
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
    override fun reset() {
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
        cardHolderPhone = ""
        cardHolderEmail = ""
        cardHolderAddress = ""
        cardHolderCity = ""
        cardHolderState = ""
        cardHolderZipCode = ""
        cardHolderCountry = ""
        acceptTermsAndConditions = false
        cardHolderIsSameAsDeliveryPerson = false
        accountNumber = ""
        accountType = ""
        bankName = ""
        bankBranch = ""
        isDataValid = false
        isLoading = false
        isError = false
    }

}