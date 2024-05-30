package com.pmalaquias.deliveryexpress.presentation.ui.pages.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import java.util.Locale

@Composable
fun CardSignUpButton(
    modifier: Modifier = Modifier,
    title: Int,
    description: Int,
    textColor: Color = Color.Unspecified

) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.headlineSmall,
            color = textColor,
            fontWeight = FontWeight.Black,
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(id = description),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = textColor,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CardSignUpButtonPreview() {
    AppTheme {
        CardSignUpButton(
            title = R.string.delivery_person_label, description = R.string.delivery_person_text
        )
    }
}

@Composable
fun CardSignUp(
    modifier: Modifier = Modifier,
    onSignUpDeliveryPersonButtonClicked: () -> Unit = {},
    onSignUpClientButtonClicked: () -> Unit = {},
) {
    val radioOptions2 = mapOf(
        R.string.delivery_person_label to R.string.delivery_person_text,
        R.string.client_label to R.string.client_text
    ).toList()
    var selectedOption by remember { mutableStateOf(radioOptions2[0]) }


    OutlinedCard(onClick = { /*TODO*/ }, modifier = modifier) {
        Column(
            modifier = modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.signup_popup_label),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.size(16.dp))
            radioOptions2.forEach { option ->
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { selectedOption = option },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (option == selectedOption) {
                        CardSignUpButton(
                            modifier = modifier.background(
                                MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(30.dp)
                            ),
                            title = option.first,
                            description = option.second,
                            textColor = MaterialTheme.colorScheme.onPrimary

                        )

                    } else {
                        CardSignUpButton(title = option.first, description = option.second)

                    }
                }

            }
            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextButton(
                    onClick =
                    if (selectedOption.first == R.string.delivery_person_label)
                        onSignUpDeliveryPersonButtonClicked else onSignUpClientButtonClicked


                ) {
                    Text(text = stringResource(id = R.string.continue_button).uppercase(Locale.ROOT))
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardSignUpPreview() {
    AppTheme {
        CardSignUp()
    }
}