package com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Outbox
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials


/**
 * This composable function creates a bottom sheet content with two buttons.
 *
 * @param height The height of the bottom sheet content. Default value is 300.dp.
 * @param backgroundColor The background color of the bottom sheet content. Default value is Color.White.
 * @param scrimColor The color of the scrim. Default value is Color.Black.
 */
@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun BottomSheetContent(
    height: Dp = 300.dp,
    backgroundColor: Color = Color.White,
    scrimColor: Color = Color.Black
) {
    // A column that contains all the elements of the bottom sheet content.
    val hazeState = remember { HazeState() }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .hazeChild(
                hazeState,
                shape = RoundedCornerShape(16.dp),
                style = HazeMaterials.ultraThin(),
            )
        //.background(MaterialTheme.colorScheme.surfaceContainerLow.copy(alpha = 0.8f)),
    ) {
        // Greeting text.
        Text("Boa Tarde,")
        // The name of the supermarket.
        Text(
            text = "Supermercado Nova Europa",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.primary
        )
        // A spacer for adding space between elements.
        Spacer(modifier = Modifier.size(16.dp))

        // A column that contains the buttons.
        Column {
            // The "New Delivery" button.
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Filled.Outbox, contentDescription = null)
                Spacer(modifier = Modifier.size(8.dp))
                Text(stringResource(id = R.string.button_new_delivery))
            }
            // The "Latest Transactions" button.
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Filled.Receipt, contentDescription = null)
                Spacer(modifier = Modifier.size(8.dp))
                Text(stringResource(id = R.string.button_latest_transactions))
            }
        }
        // A spacer for adding space between elements.
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    AppTheme {
        BottomSheetContent()
    }
}