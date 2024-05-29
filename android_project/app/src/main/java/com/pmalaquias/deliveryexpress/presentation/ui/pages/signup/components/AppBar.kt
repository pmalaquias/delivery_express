package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pmalaquias.deliveryexpress.R

@Composable
fun AppBarDeliveryPerson() {
    Text(
        text = stringResource(id = R.string.register_delivery_person),
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}


@Preview(showBackground = true)
@Composable
fun AppBarDeliveryPersonPreview() {
    AppBarDeliveryPerson()
}

@Composable
fun AppBarClient() {
    Text(
        text = stringResource(id = R.string.register_client),
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun AppBarConsumerPreview() {
    AppBarClient()
}
