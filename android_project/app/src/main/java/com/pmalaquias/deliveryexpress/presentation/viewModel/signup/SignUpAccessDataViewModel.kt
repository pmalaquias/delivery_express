package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import androidx.lifecycle.ViewModel
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.uiState.SignupAccessDataUiState
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces.IAccessDataViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for the SignUpAccessData screen.
 *
 * This ViewModel manages the UI state for the SignUpAccessData screen and provides methods to update the state.
 * It uses a `StateFlow` to expose the UI state to the UI layer.
 *
 * @property _uiState The private mutable state flow that holds the UI state.
 * @property uiState The public state flow that exposes the UI state to the UI layer.
 * @property email The email entered by the user.
 * @property confirmEmail The email confirmation entered by the user.
 * @property password The password entered by the user.
 * @property confirmPassword The password confirmation entered by the user.
 * @property isLoading A boolean indicating if the signup process is currently loading.
 */
class SignUpAccessDataViewModel: ViewModel(), IAccessDataViewModel {

    private val _uiState = MutableStateFlow(SignupAccessDataUiState())
    val uiState: StateFlow<SignupAccessDataUiState> = _uiState.asStateFlow()

    override var email: String = ""
    override var confirmEmail: String = ""
    override var password: String = ""
    override var confirmPassword: String = ""
    var isLoading: Boolean = false

    /**
     * Updates the email state.
     *
     * @param email The new email entered by the user.
     */
    override fun onEmailChange(email: String) {
        this.email = email
    }

    /**
     * Updates the email confirmation state.
     *
     * @param confirmEmail The new email confirmation entered by the user.
     */
    override fun onConfirmEmailChange(confirmEmail: String) {
        this.confirmEmail = confirmEmail
    }

    /**
     * Updates the password state.
     *
     * @param password The new password entered by the user.
     */
    override fun onPasswordChange(password: String) {
        this.password = password
    }

    /**
     * Updates the password confirmation state.
     *
     * @param confirmPassword The new password confirmation entered by the user.
     */
    override fun onConfirmPasswordChange(confirmPassword: String) {
        this.confirmPassword = confirmPassword
    }

    override fun isLoading(): Boolean {
        TODO("Not yet implemented")
    }

    override fun validateAccessData(): Boolean {
        TODO("Not yet implemented")
    }

    override fun clearError() {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    /**
     * Saves the access data.
     *
     * This method should implement the authentication logic (using a repository).
     * If the signup process is successful, it should update the UI state.
     * If the signup process fails, it should update the error state.
     */
    override fun saveAccessData() {
        // Implement authentication logic here (use repository)
        // If login is successful, update UI state
        // If login fails, update error state
    }
}