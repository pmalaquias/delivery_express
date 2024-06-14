package com.pmalaquias.deliveryexpress.presentation.viewModel.login.interfaces

interface ILoginViewModel {

    var email: String
    var password: String
    var isLoading: Boolean
    var isLoggingIn: Boolean
    var isError: Boolean
    var loginError: String

    fun onEmailChange(email: String)
    fun onPasswordChange(password: String)
    fun onLoadingChange(isLoading: Boolean)
    fun onErrorChange(isError: Boolean)
    fun reset()
    fun validateLoginData(): Boolean
    fun clearError()
    fun login()
}