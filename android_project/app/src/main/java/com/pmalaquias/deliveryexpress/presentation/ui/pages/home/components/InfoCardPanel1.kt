package com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A composable function that displays an information card panel.
 *
 * @param titleLabel The title of the card. Default value is "Saldo Disponível".
 */
@Composable
fun InfoCardPanel1(
    titleLabel: String = "Saldo Disponível",
) {
    // A Card layout that fills the maximum width and has a height of 100.dp.
    // It also has a padding of 8.dp at the top and bottom.
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, top = 8.dp)
            .height(100.dp)
    ) {
        // A Column layout that centers its children horizontally and vertically.
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Displays the title of the card.
            Text(titleLabel)
            // Displays the value of the card with bold font and a font size of 24.sp.
            Text(
                "R$ 99,00", fontWeight = FontWeight.Bold, fontSize = 24.sp
            )
        }
    }
}
