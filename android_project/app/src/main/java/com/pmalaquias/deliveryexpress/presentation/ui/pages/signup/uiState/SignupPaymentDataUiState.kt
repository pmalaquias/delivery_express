package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState

import com.pmalaquias.deliveryexpress.data.models.enums.CardBrand
import java.util.Date

/**
 * Data class representing the UI state for the signup payment data screen.
 *
 * @property name The name of the user. Default value is an empty string.
 * @property email The email of the user. Default value is an empty string.
 * @property phone The phone number of the user. Default value is an empty string.
 * @property address The address of the user. Default value is an empty string.
 * @property city The city of the user. Default value is an empty string.
 * @property state The state of the user. Default value is an empty string.
 * @property zipCode The zip code of the user. Default value is 0.
 * @property country The country of the user. Default value is an empty string.
 * @property cardNumber The card number of the user. Default value is 0.
 * @property cardExpiration The card expiration date. Default value is the current date.
 * @property cardCvv The card CVV. Default value is 0.
 * @property cardBrand The card brand. It can be null if the user has not selected a card brand.
 * @property cardHolderName The name of the card holder. Default value is an empty string.
 * @property cardHolderPhone The phone number of the card holder. Default value is 0.
 * @property cardHolderEmail The email of the card holder. Default value is an empty string.
 * @property cardHolderAddress The address of the card holder. Default value is an empty string.
 * @property cardHolderCity The city of the card holder. Default value is an empty string.
 * @property cardHolderState The state of the card holder. Default value is an empty string.
 * @property cardHolderZipCode The zip code of the card holder. Default value is 0.
 * @property cardHolderCountry The country of the card holder. Default value is an empty string.
 * @property acceptTermsAndConditions A boolean representing if the user has accepted the terms and conditions. Default value is false.
 * @property cardHolderIsSameAsDeliveryPerson A boolean representing if the card holder is the same as the delivery person. Default value is false.
 * @property accountNumber The account number of the user. Default value is 0.
 * @property accountType The account type of the user. Default value is an empty string.
 * @property bankName The bank name of the user. Default value is an empty string.
 * @property bankBranch The bank branch of the user. Default value is an empty string.
 * @property isDataValid A boolean representing if the data is valid. Default value is false.
 * @property isLoading A boolean representing if the signup process is loading. Default value is false.
 * @property isError A boolean representing if there is an error. Default value is false.
 */
data class SignupPaymentDataUiState(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val address: String = "",
    val city: String = "",
    val state: String = "",
    val zipCode: Int = 0,
    val country: String = "",
    val cardNumber: Int = 0,
    val cardExpiration: Date = Date(),
    val cardCvv: Int = 0,
    val cardBrand: CardBrand? = null,
    val cardHolderName: String = "",
    val cardHolderPhone: Int = 0,
    val cardHolderEmail: String = "",
    val cardHolderAddress: String = "",
    val cardHolderCity: String = "",
    val cardHolderState: String = "",
    val cardHolderZipCode: Int = 0,
    val cardHolderCountry: String = "",
    val acceptTermsAndConditions: Boolean = false,
    val cardHolderIsSameAsDeliveryPerson: Boolean = false,
    val accountNumber: Int = 0,
    val accountType: String = "",
    val bankName: String = "",
    val bankBranch: String = "",
    val isDataValid: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)
