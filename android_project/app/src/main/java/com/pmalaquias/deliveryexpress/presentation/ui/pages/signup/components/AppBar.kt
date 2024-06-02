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



/**
 * A composable function that displays an AppBar for the Delivery Person registration screen.
 *
 * This AppBar displays a centered text, which is a string resource with the id `R.string.register_delivery_person`.
 * The text uses the `headlineLarge` style from the current Material Theme.
 * The text is also set to fill the maximum width available, aligning its content to the center.
 *
 * This composable does not take any parameters and does not return any value.
 * */
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

/**
 * A composable function that displays an AppBar for the Client registration screen.
 *
 * This AppBar displays a centered text, which is a string resource with the id `R.string.register_client`.
 * The text uses the `headlineLarge` style from the current Material Theme.
 * The text is also set to fill the maximum width available, aligning its content to the center.
 *
 * This composable does not take any parameters and does not return any value.
 * */
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
