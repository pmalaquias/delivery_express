package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.data.models.enums.CardBrand
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.CardView
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.RadioOptionCardBrandCustom
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import com.pmalaquias.deliveryexpress.presentation.ui.utils.MaskVisualTransformation
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpPaymentDataViewModel
import java.util.Date

@Composable
fun SignUpPaymentClientDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    val viewModel: SignUpPaymentDataViewModel = viewModel()

    var monthExpiration by rememberSaveable { mutableStateOf("") }
    var yearExpiration by rememberSaveable { mutableStateOf("") }

    var cardBrandGroup: CardBrand? by rememberSaveable { mutableStateOf(CardBrand.UNKNOWN) }

    val valueVehicleTypeChangedHandler: (CardBrand?) -> Unit = { value: CardBrand? ->
        viewModel.onCardBrandChange(value.toString())
        cardBrandGroup = value
    }

    val CREDIT_CARD_MASK = "#### #### #### ####"

    Scaffold(
        Modifier,
        topBar = { AppBarClient() }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
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
                        onCheckedChange = {
                            viewModel.onCardHolderIsSameAsDeliveryPersonChange(it)
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
                    modifier = modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RadioOptionCardBrandCustom(
                        value = CardBrand.MASTERCARD,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cardBrandGroup,
                        img = painterResource(id = R.drawable.mastercard_logo),
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    RadioOptionCardBrandCustom(
                        value = CardBrand.VISA,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cardBrandGroup,
                        img = painterResource(id = R.drawable.visa),
                        color = Color(0xFF2566AF)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    RadioOptionCardBrandCustom(
                        value = CardBrand.HIPERCARD,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cardBrandGroup,
                        img = painterResource(id = R.drawable.hipercard),
                        color = Color(0xFFB3131B)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    RadioOptionCardBrandCustom(
                        value = CardBrand.ELO,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cardBrandGroup,
                        img = painterResource(id = R.drawable.elo),
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    RadioOptionCardBrandCustom(
                        value = CardBrand.AMEX,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cardBrandGroup,
                        img = painterResource(id = R.drawable.american_express_logo2),
                        color = Color(0xFF016FD0)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    RadioOptionCardBrandCustom(
                        value = CardBrand.JCB,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cardBrandGroup,
                        img = painterResource(id = R.drawable.jcb_logo),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    RadioOptionCardBrandCustom(
                        value = CardBrand.DINERS_CLUB,
                        onValueChange = valueVehicleTypeChangedHandler,
                        valueGroup = cardBrandGroup,
                        img = painterResource(id = R.drawable.diners_club),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                }

                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.cardNumber,
                    onValueChange = {
                        viewModel.onCardNumberChange(it)

                    },
                    label = { Text(stringResource(id = R.string.card_number)) },
                    modifier = modifier.fillMaxWidth(),
                    visualTransformation = MaskVisualTransformation(CREDIT_CARD_MASK)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextField(
                        value = monthExpiration,
                        onValueChange = { monthExpiration = it },
                        label = { Text(stringResource(id = R.string.expiry_month)) },
                        modifier = modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    TextField(
                        value = yearExpiration,
                        onValueChange = { yearExpiration = it },
                        label = { Text(stringResource(id = R.string.expiry_year)) },
                        modifier = modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                if (cardBrandGroup == CardBrand.UNKNOWN) {
                    Spacer(modifier = Modifier.padding(8.dp))

                } else {
                    CardView(
                        cardNumber = viewModel.cardNumber,
                        cardBrand = cardBrandGroup!!,
                        expDateMonth = monthExpiration,
                        expDateYear = yearExpiration
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                }
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
                        onCheckedChange = { viewModel.onAcceptTermsAndConditionsChange(it) }
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
                Button(onClick = {
                    val year = yearExpiration.toInt() + 2000
                    val date = Date(
                        year - 1900,
                        monthExpiration.toInt() - 1,
                        1
                    )
                    viewModel.onCardExpirationChange(date)
                    onNextButtonClicked()
                }) {
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