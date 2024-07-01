package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpPaymentDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces.IPaymentDataViewModel

@Composable
fun SignUpPaymentDeliveryPersonDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: IPaymentDataViewModel
) {


    Scaffold(
        Modifier,
        topBar = { AppBarDeliveryPerson() }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.payment_data_title),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Switch(
                        checked = viewModel.cardHolderIsSameAsDeliveryPerson,
                        onCheckedChange = {viewModel.onCardHolderIsSameAsDeliveryPersonChange(it)}
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.confirm_previously_used_data),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.bankName,
                    onValueChange = { viewModel.onBankNameChange(it) },
                    label = { Text(stringResource(id = R.string.bank_name)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.accountType,
                    onValueChange = { viewModel.onAccountTypeChange(it) },
                    label = { Text(stringResource(id = R.string.account_type)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = viewModel.bankBranch,
                    onValueChange = { viewModel.onBankBranchChange(it) },
                    label = { Text(stringResource(id = R.string.bank_branch)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.accountNumber.toString(),
                    onValueChange = { viewModel.onAccountNumberChange(it)},
                    label = { Text(stringResource(id = R.string.account_number)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = stringResource(id = R.string.change_receipt_data),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    modifier = modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(32.dp))

                Row() {
                    Checkbox(
                        checked = viewModel.acceptTermsAndConditions,
                            onCheckedChange = {viewModel.onAcceptTermsAndConditionsChange(it)}                )
                    Text(
                        text = stringResource(id = R.string.i_accept_terms_of_use),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp, )
                }
                Spacer(modifier = Modifier.size(16.dp))
            }

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
fun PreviewSignUpPaymentDataPage() {
    AppTheme {
        SignUpPaymentDeliveryPersonDataPage(viewModel = SignUpPaymentDataViewModel())
    }
}

