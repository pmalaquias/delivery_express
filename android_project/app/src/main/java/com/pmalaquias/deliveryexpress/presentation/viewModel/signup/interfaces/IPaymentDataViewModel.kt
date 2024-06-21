package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

import java.util.Date

/**
 * An interface that defines the properties and methods for managing payment data in a ViewModel.
 *
 * This interface is designed to be implemented by ViewModel classes that need to handle user payment data, such as card details, bank account details, and personal information.
 */
interface IPaymentDataViewModel {

    /**
     * The user's name.
     */
    var name: String

    /**
     * The user's email.
     */
    var email: String

    /**
     * The user's phone number.
     */
    var phone: String

    /**
     * The user's address.
     */
    var address: String

    /**
     * The user's city.
     */
    var city: String

    /**
     * The user's state.
     */
    var state: String

    /**
     * The user's zip code.
     */
    var zipCode: String

    /**
     * The user's country.
     */
    var country: String

    /**
     * The user's card number.
     */
    var cardNumber: String

    /**
     * The user's card expiration date.
     */
    var cardExpiration: Date

    /**
     * The user's card CVV number.
     */
    var cardCvv: String

    /**
     * The user's card brand.
     */
    var cardBrand: String

    /**
     * The card holder's name.
     */
    var cardHolderName: String

    /**
     * The card holder's phone number.
     */
    var cardHolderPhone: String

    /**
     * The card holder's email.
     */
    var cardHolderEmail: String

    /**
     * The card holder's address.
     */
    var cardHolderAddress: String

    /**
     * The card holder's city.
     */
    var cardHolderCity: String

    /**
     * The card holder's state.
     */
    var cardHolderState: String

    /**
     * The card holder's zip code.
     */
    var cardHolderZipCode: String

    /**
     * The card holder's country.
     */
    var cardHolderCountry: String

    /**
     * A boolean indicating if the card holder is the same as the delivery person.
     */
    var cardHolderIsSameAsDeliveryPerson: Boolean

    /**
     * A boolean indicating if the user accepts the terms and conditions.
     */
    var acceptTermsAndConditions: Boolean

    /**
     * The user's bank account number.
     */
    var accountNumber: String

    /**
     * The user's bank agency.
     */
    var agency: String

    /**
     * The user's bank name.
     */
    var bankName: String

    /**
     * The user's account type.
     */
    var accountType: String

    /**
     * The user's bank branch.
     */
    var bankBranch: String

    /**
     * A boolean indicating if the data is valid.
     */
    var isDataValid: Boolean

    /**
     * A boolean indicating if the ViewModel is currently loading data.
     */
    var isLoading: Boolean

    /**
     * A boolean indicating if there is an error.
     */
    var isError : Boolean

    /**
     * Updates the value of the "name" field.
     *
     * @param name The new value of the "name" field.
     */
    fun onNameChange(name: String)

    /**
     * Updates the value of the "email" field.
     *
     * @param email The new value of the "email" field.
     */
    fun onEmailChange(email: String)

    /**
     * Updates the value of the "phone" field.
     *
     * @param phone The new value of the "phone" field.
     */
    fun onPhoneChange(phone: String)

    /**
     * Updates the value of the "address" field.
     *
     * @param address The new value of the "address" field.
     */
    fun onAddressChange(address: String)

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
     * Updates the value of the "zipCode" field.
     *
     * @param zipCode The new value of the "zipCode" field.
     */
    fun onZipCodeChange(zipCode: String)

    /**
     * Updates the value of the "country" field.
     *
     * @param country The new value of the "country" field.
     */
    fun onCountryChange(country: String)

    /**
     * Updates the value of the "cardNumber" field.
     *
     * @param cardNumber The new value of the "cardNumber" field.
     */
    fun onCardNumberChange(cardNumber: String)

    /**
     * Updates the value of the "cardExpiration" field.
     *
     * @param cardExpiration The new value of the "cardExpiration" field.
     */
    fun onCardExpirationChange(cardExpiration: Date)

    /**
     * Updates the value of the "cardCvv" field.
     *
     * @param cardCvv The new value of the "cardCvv" field.
     */
    fun onCardCvvChange(cardCvv: String)

    /**
     * Updates the value of the "cardBrand" field.
     *
     * @param cardBrand The new value of the "cardBrand" field.
     */
    fun onCardBrandChange(cardBrand: String)

    /**
     * Updates the value of the "cardHolderName" field.
     *
     * @param cardHolderName The new value of the "cardHolderName" field.
     */
    fun onCardHolderNameChange(cardHolderName: String)

    /**
     * Updates the value of the "cardHolderPhone" field.
     *
     * @param cardHolderPhone The new value of the "cardHolderPhone" field.
     */
    fun onCardHolderPhoneChange(cardHolderPhone: String)

    /**
     * Updates the value of the "cardHolderEmail" field.
     *
     * @param cardHolderEmail The new value of the "cardHolderEmail" field.
     */
    fun onCardHolderEmailChange(cardHolderEmail: String)

    /**
     * Updates the value of the "cardHolderAddress" field.
     *
     * @param cardHolderAddress The new value of the "cardHolderAddress" field.
     */
    fun onCardHolderAddressChange(cardHolderAddress: String)

    /**
     * Updates the value of the "cardHolderCity" field.
     *
     * @param cardHolderCity The new value of the "cardHolderCity" field.
     */
    fun onCardHolderCityChange(cardHolderCity: String)

    /**
     * Updates the value of the "cardHolderState" field.
     *
     * @param cardHolderState The new value of the "cardHolderState" field.
     */
    fun onCardHolderStateChange(cardHolderState: String)

    /**
     * Updates the value of the "cardHolderZipCode" field.
     *
     * @param cardHolderZipCode The new value of the "cardHolderZipCode" field.
     */
    fun onCardHolderZipCodeChange(cardHolderZipCode: String)

    /**
     * Updates the value of the "cardHolderCountry" field.
     *
     * @param cardHolderCountry The new value of the "cardHolderCountry" field.
     */
    fun onCardHolderCountryChange(cardHolderCountry: String)

    /**
     * Updates the value of the "cardHolderIsSameAsDeliveryPerson" field.
     *
     * @param cardHolderIsSameAsDeliveryPerson The new value of the "cardHolderIsSameAsDeliveryPerson" field.
     */
    fun onCardHolderIsSameAsDeliveryPersonChange(cardHolderIsSameAsDeliveryPerson: Boolean)

    /**
     * Updates the value of the "acceptTermsAndConditions" field.
     *
     * @param acceptTermsAndConditions The new value of the "acceptTermsAndConditions" field.
     */
    fun onAcceptTermsAndConditionsChange(acceptTermsAndConditions: Boolean)

    /**
     * Updates the value of the "accountNumber" field.
     *
     * @param accountNumber The new value of the "accountNumber" field.
     */
    fun onAccountNumberChange(accountNumber: String)

    /**
     * Updates the value of the "agency" field.
     *
     * @param agency The new value of the "agency" field.
     */
    fun onAgencyChange(agency: String)

    /**
     * Updates the value of the "bankName" field.
     *
     * @param bankName The new value of the "bankName" field.
     */
    fun onBankNameChange(bankName: String)

    /**
     * Updates the value of the "accountType" field.
     *
     * @param accountType The new value of the "accountType" field.
     */
    fun onAccountTypeChange(accountType: String)

    /**
     * Updates the value of the "bankBranch" field.
     *
     * @param bankBranch The new value of the "bankBranch" field.
     */
    fun onBankBranchChange(bankBranch: String)

    /**
     * Updates the value of the "isLoading" field.
     *
     * @param isLoading The new value of the "isLoading" field.
     */
    fun onLoadingChange(isLoading: Boolean)

    /**
     * Updates the value of the "isError" field.
     *
     * @param isError The new value of the "isError" field.
     */
    fun onIsErrorChange(isError: Boolean)

    /**
     * Validates the payment data entered by the user.
     *
     * This function checks whether all the input fields on the payment data screen have been filled out.
     *
     * @return true if all the input fields have been filled out, false otherwise.
     */
    fun validatePaymentData(): Boolean

    /**
     * Updates the value of the "isDataValid" field.
     *
     * @param isDataValid The new value of the "isDataValid" field.
     */
    fun onIsDataValidChange(isDataValid: Boolean)

    /**
     * Clears the error state of the ViewModel.
     *
     * This function should be called when the user has acknowledged an error message, to remove the error message from the UI.
     */
    fun clearError()

    /**
     * Saves the payment data entered by the user.
     *
     * This function should be called when the user clicks the "Save" button on the payment data screen.
     */
    fun savePaymentData()

    /**
     * Resets the ViewModel to its initial state.
     */
    fun reset()
}