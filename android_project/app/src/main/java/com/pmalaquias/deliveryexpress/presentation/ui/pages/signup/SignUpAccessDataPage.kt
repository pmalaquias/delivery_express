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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

@Composable
fun SignUpAccessDeliveryPersonDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }


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
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.email_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.confirm_email)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.password_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.confirm_password)) },
                    modifier = modifier.fillMaxWidth(),
                )
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
fun SignUpAccessDataPagePreview() {
    AppTheme {
        SignUpAccessDeliveryPersonDataPage()
    }
}

@Composable
fun SignUpAccessClientDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }


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
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.email_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.confirm_email)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.password_label)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.confirm_password)) },
                    modifier = modifier.fillMaxWidth(),
                )
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
fun SignUpAccessClientDataPagePreview() {
    AppTheme {
        SignUpAccessClientDataPage()
    }
}