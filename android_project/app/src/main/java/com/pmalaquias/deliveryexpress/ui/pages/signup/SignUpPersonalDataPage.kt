package com.pmalaquias.deliveryexpress.ui.pages.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpPersonalDeliveryPersonDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }

    Scaffold(
        Modifier.padding(16.dp),
        topBar = { AppBarDeliveryPerson()}
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
                Text(
                    text = stringResource(id = R.string.personal_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))
                Box(modifier = modifier.size(200.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.unknown_person),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Transparent, CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                    ) {
                        Icon(
                            Icons.Outlined.Add,
                            contentDescription = stringResource(id = R.string.add_photo),
                            tint = Color.White,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.White, CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer)
                        )
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.full_name)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = {
                        val newText = it.replace("[^0-9]".toRegex(), "")
                        text = newText

                        if (newText.length == 8) {
                            //formattedDate.value = sdf.format(Date(newText.toLong()))
                        }


                    },

                    label = { Text(stringResource(id = R.string.birth_date)) },
                    modifier = modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.cpf)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.phone_number)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))


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
fun SignUpPagePreview() {
    AppTheme {
        SignUpPersonalDeliveryPersonDataPage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpPersonalClientDataPage(
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.personal_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))
                Box(modifier = modifier.size(200.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.unknown_person),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Transparent, CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                    ) {
                        Icon(
                            Icons.Outlined.Add,
                            contentDescription = stringResource(id = R.string.add_photo),
                            tint = Color.White,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.White, CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer)
                        )
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.full_name)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.commercialName)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = {
                        val newText = it.replace("[^0-9]".toRegex(), "")
                        text = newText

                        if (newText.length == 8) {
                            //formattedDate.value = sdf.format(Date(newText.toLong()))
                        }


                    },

                    label = { Text(stringResource(id = R.string.birth_date)) },
                    modifier = modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.cpf)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.phone_number)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))


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
fun SignUpPersonalClientDataPagePreview() {
    AppTheme {
        SignUpPersonalClientDataPage()
    }
}