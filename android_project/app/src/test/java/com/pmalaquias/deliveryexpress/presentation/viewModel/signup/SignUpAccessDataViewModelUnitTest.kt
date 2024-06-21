package com.pmalaquias.deliveryexpress.presentation.viewModel.signup

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

class SignUpAccessDataViewModelTest {

    private val viewModel = SignUpAccessDataViewModel()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `onEmailChange updates email state`(): Unit = runBlockingTest {
        viewModel.onEmailChange("test@example.com")
        assertEquals("test@example.com", viewModel.uiState.first().email)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `onConfirmEmailChange updates confirmEmail state`(): Unit = runBlockingTest {
        viewModel.onConfirmEmailChange("test@example.com")
        assertEquals("test@example.com", viewModel.uiState.first().confirmEmail)
    }

    @Test
    fun `onPasswordChange updates password state`(): Unit = runBlockingTest {
        viewModel.onPasswordChange("password")
        assertEquals("password", viewModel.uiState.first().password)
    }

    @Test
    fun `onConfirmPasswordChange updates confirmPassword state`(): Unit = runBlockingTest {
        viewModel.onConfirmPasswordChange("password")
        assertEquals("password", viewModel.uiState.first().confirmPassword)
    }

    // Note: The `saveAccessData` method is not tested here because it's not implemented.
    // Once the method is implemented, you should add tests for it.
    // The tests should cover both the successful and unsuccessful cases.
}