package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpAccessDataViewModel

/**
 * Composable function that represents the SignUpAccessDeliveryPersonDataPage.
 *
 * This page is used for the delivery person to enter their access data during the signup process.
 * It contains text fields for email, confirm email, password, and confirm password.
 * It also contains a back button and a continue button.
 *
 * @param onCancelButtonClicked A lambda function that is called when the back button is clicked.
 * @param onNextButtonClicked A lambda function that is called when the continue button is clicked.
 * @param modifier A Modifier that is applied to the root layout of this composable.
 */
@Composable
fun SignUpAccessDeliveryPersonDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    // ViewModel for this page
    val viewModel: SignUpAccessDataViewModel = viewModel()

    // Scaffold for the layout of this page
    Scaffold(
        Modifier,
        topBar = { AppBarDeliveryPerson() }
    ) { innerPadding ->

        // Main layout of this page
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Layout for the text fields
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.access_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = viewModel.email,
                    onValueChange = { viewModel.onEmailChange(it) },
                    label = { Text(stringResource(id = R.string.email_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.confirmEmail,
                    onValueChange = { viewModel.onConfirmEmailChange(it) },
                    label = { Text(stringResource(id = R.string.confirm_email)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.onPasswordChange(it) },
                    label = { Text(stringResource(id = R.string.password_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = viewModel.confirmPassword,
                    onValueChange = { viewModel.onConfirmPasswordChange(it) },
                    label = { Text(stringResource(id = R.string.confirm_password)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))
            }

            // Layout for the back and continue buttons
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = onCancelButtonClicked
                ) {
                    Text(text = stringResource(id = R.string.back_button))
                }
                Button(onClick = onNextButtonClicked) {
                    Text(text = stringResource(id = R.string.continue_button))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpAccessDataPagePreview() {
    AppTheme {
        SignUpAccessDeliveryPersonDataPage()
    }
}

/**
 * Composable function that represents the SignUpAccessClientDataPage.
 *
 * This page is used for the client to enter their access data during the signup process.
 * It contains text fields for email, confirm email, password, and confirm password.
 * It also contains a back button and a continue button.
 *
 * @param onCancelButtonClicked A lambda function that is called when the back button is clicked.
 * @param onNextButtonClicked A lambda function that is called when the continue button is clicked.
 * @param modifier A Modifier that is applied to the root layout of this composable.
 */
@Composable
fun SignUpAccessClientDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    // ViewModel for this page
    val viewModel: SignUpAccessDataViewModel = viewModel()

    // Scaffold for the layout of this page
    Scaffold(
        Modifier,
        topBar = { AppBarClient() }
    ) { innerPadding ->

        // Main layout of this page
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Layout for the text fields
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.access_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = viewModel.email,
                    onValueChange = { viewModel.onEmailChange(it) },
                    label = { Text(stringResource(id = R.string.email_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.confirmEmail,
                    onValueChange = { viewModel.onConfirmEmailChange(it) },
                    label = { Text(stringResource(id = R.string.confirm_email)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.onPasswordChange(it) },
                    label = { Text(stringResource(id = R.string.password_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = viewModel.confirmPassword,
                    onValueChange = { viewModel.onConfirmPasswordChange(it)},
                    label = { Text(stringResource(id = R.string.confirm_password)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))


            }
            // Layout for the back and continue buttons
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = onCancelButtonClicked
                ) {
                    Text(text = stringResource(id = R.string.back_button))
                }
                Button(onClick = onNextButtonClicked) {
                    Text(text = stringResource(id = R.string.continue_button))

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpAccessClientDataPagePreview() {
    AppTheme {
        SignUpAccessClientDataPage()
    }
}