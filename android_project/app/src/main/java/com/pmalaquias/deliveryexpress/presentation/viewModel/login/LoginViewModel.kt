package com.pmalaquias.deliveryexpress.presentation.viewModel.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmalaquias.deliveryexpress.presentation.ui.pages.login.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel class for the Login screen.
 *
 * @property _uiState Private MutableStateFlow that holds the current state of the UI.
 * @property uiState Public StateFlow that exposes the current state of the UI. It's a read-only version of _uiState.
 * @property email A mutable state representing the email entered by the user.
 * @property password A mutable state representing the password entered by the user.
 * @property isLoggingIn A mutable state representing whether the login process is ongoing.
 * @property loginError A mutable state representing any error that occurred during the login process.
 *
 * @function login Function to initiate the login process. It sets isLoggingIn to true, then launches a coroutine
 * where the actual authentication logic should be implemented. After the coroutine finishes, it sets isLoggingIn back to false.
 *
 * @function clearError Function to clear any login error. It sets loginError to null.
 */
class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    // UI state
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoggingIn by mutableStateOf(false)
    var loginError by mutableStateOf<String?>(null)

    // Function to perform login
    fun login() {
        isLoggingIn = true

        viewModelScope.launch {
            // Implement authentication logic here (use repository)
            // If login is successful, update UI state
            // If login fails, update error state

            isLoggingIn = false
        }
    }

    // Function to handle email input
    fun onEmailChange(email: String) {
        try {
            this.email = email
            println(email)
        } catch (e: Exception) {
            println(e)
        }
    }

    // Function to handle password input
    fun onPasswordChange(password: String) {
        this.password = password
        println(password)
    }

    // Function to clear error state
    fun clearError() {
        loginError = null
    }

}