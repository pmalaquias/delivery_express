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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.RadioOptionCardBrandCustom
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

@Composable
fun SignUpPaymentDeliveryPersonDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }

    var checked by remember { mutableStateOf(false) }

    val checkedState = remember { mutableStateOf(false) }


    Scaffold(
        Modifier.padding(16.dp),
        topBar = { AppBarDeliveryPerson() }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.payment_data_title ),
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
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.confirm_previously_used_data),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.bank_name)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.account_type)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.bank_branch)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
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
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it }
                    )
                    Text(
                        text = stringResource(id = R.string.i_accept_terms_of_use),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,

                        )
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
        SignUpPaymentDeliveryPersonDataPage()
    }
}

enum class CardBrand {
    VISA,
    MASTERCARD,
    ELO,
    HIPERCARD,
    AMEX,
    DISCOVER,
    JCB,
    DINERS_CLUB,
    UNKNOWN
}

@Composable
fun SignUpPaymentClientDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }

    var checked by remember { mutableStateOf(false) }

    val checkedState = remember { mutableStateOf(false) }

    var cadBrandGroup: CardBrand? by rememberSaveable { mutableStateOf(CardBrand.UNKNOWN) }

    val valueVehicleTypeChangedHandler: (CardBrand?) -> Unit = { value: CardBrand? ->
        cadBrandGroup = value
    }


    Scaffold(
        Modifier.padding(16.dp),
        topBar = { AppBarClient() }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.payment_data_title ),
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
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.confirm_previously_used_data),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    RadioOptionCardBrandCustom(
                        value = CardBrand.MASTERCARD,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cadBrandGroup,
                        img = painterResource(id = R.drawable.mastercard_logo),
                        color = Color.Black
                    )
                    RadioOptionCardBrandCustom(
                        value = CardBrand.VISA,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cadBrandGroup,
                        img = painterResource(id = R.drawable.visa),
                        color = Color(0xFF2566AF)
                    )

                    RadioOptionCardBrandCustom(
                        value = CardBrand.HIPERCARD,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cadBrandGroup,
                        img = painterResource(id = R.drawable.hipercard),
                        color = Color(0xFFB3131B)
                    )
                    RadioOptionCardBrandCustom(
                        value = CardBrand.ELO,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cadBrandGroup,
                        img = painterResource(id = R.drawable.elo),
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.card_number )) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextField(
                        value = text,
                        onValueChange = { /*TODO*/ },
                        label = { Text(stringResource(id = R.string.expiry_month ) ) },
                        modifier = modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    TextField(
                        value = text,
                        onValueChange = { /*TODO*/ },
                        label = { Text(stringResource(id = R.string.expiry_year) ) },
                        modifier = modifier.weight(1f)
                    )
                }
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
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it }
                    )
                    Text(
                        text = stringResource(id = R.string.i_accept_terms_of_use),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,

                        )
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
fun PreviewSignUpPaymentClientDataPage() {
    AppTheme {
        SignUpPaymentClientDataPage()
    }
}
