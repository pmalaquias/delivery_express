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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.RadioOptionTypeCustom
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

enum class DeliveryType {
    Food,
    Clothing,
    Documents,
    FragileOrder,
    HeavyOrder,
    Other,
}

@Composable
fun SignUpDeliveryDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {


    var deliveryGroup: DeliveryType? by rememberSaveable { mutableStateOf(DeliveryType.Food) }

    val valueDeliveryTypeChangedHandler: (DeliveryType?) -> Unit = { value: DeliveryType? ->
        deliveryGroup = value
    }

    Scaffold(
        Modifier.padding(16.dp),
        topBar = { AppBarClient() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.delivery_data),
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 24.sp
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))

                Text(text = stringResource(id = R.string.delivery_type))
                Spacer(modifier = Modifier.size(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RadioOptionTypeCustom(
                        value = DeliveryType.Food,
                        valueGroup = deliveryGroup,
                        onValueChange = valueDeliveryTypeChangedHandler,
                        label = stringResource(id =R.string.delivery_food),
                        img = painterResource(id = R.drawable.food),
                    )
                    RadioOptionTypeCustom(
                        value = DeliveryType.Clothing,
                        valueGroup = deliveryGroup,
                        onValueChange = valueDeliveryTypeChangedHandler,
                        label = stringResource(id =R.string.delivery_clothing),
                        img = painterResource(id = R.drawable.clothing),
                    )
                    RadioOptionTypeCustom(
                        value = DeliveryType.Documents,
                        valueGroup = deliveryGroup,
                        onValueChange = valueDeliveryTypeChangedHandler,
                        label = stringResource(id =R.string.delivery_document),
                        img = painterResource(id = R.drawable.documents),
                    )

                }
                Spacer(modifier = Modifier.size(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RadioOptionTypeCustom(
                        value = DeliveryType.FragileOrder,
                        valueGroup = deliveryGroup,
                        onValueChange = valueDeliveryTypeChangedHandler,
                        label = stringResource(id =R.string.delivery_fragile_order),
                        img = painterResource(id = R.drawable.fragile_order),
                    )
                    RadioOptionTypeCustom(
                        value = DeliveryType.HeavyOrder,
                        valueGroup = deliveryGroup,
                        onValueChange = valueDeliveryTypeChangedHandler,
                        label = stringResource(id =R.string.delivery_heavy_order),
                        img = painterResource(id = R.drawable.heavy_order),
                    )
                    RadioOptionTypeCustom(
                        value = DeliveryType.Other,
                        valueGroup = deliveryGroup,
                        onValueChange = valueDeliveryTypeChangedHandler,
                        label = stringResource(id =R.string.delivery_other),
                        img = painterResource(id = R.drawable.other_delivery),
                    )

                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.delivery_data_info),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                )

            }
            Row(
                modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
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
fun SignUpDeliveryDataPagePreview() {
    AppTheme {
        SignUpDeliveryDataPage()
    }
}