package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

import java.util.Date

interface IPaymentDataViewModel {

    var name: String
    var email: String
    var phone: String
    var address: String
    var city: String
    var state: String
    var zipCode: Int
    var country: String
    var cardNumber: String
    var cardExpiration: Date
    var cardCvv: Int
    var cardBrand: String
    var cardHolderName: String
    var cardHolderPhone: String
    var cardHolderEmail: String
    var cardHolderAddress: String
    var cardHolderCity: String
    var cardHolderState: String
    var cardHolderZipCode: String
    var cardHolderCountry: String
    var cardHolderIsSameAsDeliveryPerson: Boolean
    var acceptTermsAndConditions: Boolean
    var accountNumber: String
    var agency: String
    var bankName: String
    var accountType: String
    var bankBranch: String
    var isDataValid: Boolean
    var isLoading: Boolean
    var isError : Boolean

    fun onNameChange(name: String)
    fun onEmailChange(email: String)
    fun onPhoneChange(phone: String)
    fun onAddressChange(address: String)
    fun onCityChange(city: String)
    fun onStateChange(state: String)
    fun onZipCodeChange(zipCode: Int)
    fun onCountryChange(country: String)
    fun onCardNumberChange(cardNumber: String)
    fun onCardExpirationChange(cardExpiration: Date)
    fun onCardCvvChange(cardCvv: Int)
    fun onCardBrandChange(cardBrand: String)
    fun onCardHolderNameChange(cardHolderName: String)
    fun onCardHolderPhoneChange(cardHolderPhone: String)
    fun onCardHolderEmailChange(cardHolderEmail: String)
    fun onCardHolderAddressChange(cardHolderAddress: String)
    fun onCardHolderCityChange(cardHolderCity: String)
    fun onCardHolderStateChange(cardHolderState: String)
    fun onCardHolderZipCodeChange(cardHolderZipCode: String)
    fun onCardHolderCountryChange(cardHolderCountry: String)
    fun onCardHolderIsSameAsDeliveryPersonChange(cardHolderIsSameAsDeliveryPerson: Boolean)
    fun onAcceptTermsAndConditionsChange(acceptTermsAndConditions: Boolean)
    fun onAccountNumberChange(accountNumber: String)
    fun onAgencyChange(agency: String)
    fun onBankNameChange(bankName: String)
    fun onAccountTypeChange(accountType: String)
    fun onBankBranchChange(bankBranch: String)
    fun onLoadingChange(isLoading: Boolean)
    fun onIsErrorChange(isError: Boolean)
    fun validatePaymentData(): Boolean
    fun onIsDataValidChange(isDataValid: Boolean)
    fun clearError()
    fun savePaymentData()
    fun reset()
}