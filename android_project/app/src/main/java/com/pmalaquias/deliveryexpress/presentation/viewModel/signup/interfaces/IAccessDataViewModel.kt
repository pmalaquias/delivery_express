package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

interface IAccessDataViewModel {
    var email: String
    var confirmEmail: String
    var password: String
    var confirmPassword: String

    fun onEmailChange(email: String)
    fun onConfirmEmailChange(confirmEmail: String)
    fun onPasswordChange(password: String)
    fun onConfirmPasswordChange(confirmPassword: String)
    fun isLoading(): Boolean
    fun validateAccessData(): Boolean
    fun clearError()
    fun showError(message: String)
    fun saveAccessData()
}