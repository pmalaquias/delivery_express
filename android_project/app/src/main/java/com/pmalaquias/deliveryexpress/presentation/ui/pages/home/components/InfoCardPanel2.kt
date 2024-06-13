package com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A composable function that displays an information card panel.
 *
 * @param titleLabel The title of the card. Default value is "TitleLabel".
 * @param subTitleValue The subtitle of the card. Default value is "SubTitleValue".
 * @param hasIcon A boolean value that determines if the card should display an icon. Default value is false.
 * @param icon The icon to display if hasIcon is true. Default icon is Icons.Filled.Star.
 * @param hasInfo A boolean value that determines if the card should display additional info. Default value is false.
 * @param modifier The modifier to apply to the Column layout.
 */
@Composable
fun InfoCardPanel2(
    titleLabel: String = "TitleLabel",
    subTitleValue: String = "SubTitleValue",
    hasIcon: Boolean = false,
    icon: ImageVector = Icons.Filled.Star,
    hasInfo: Boolean = false,
    modifier: Modifier = Modifier
) {

    // A Column layout that centers its children horizontally and vertically.
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Displays the title of the card.
        Text(titleLabel)

        // If hasIcon is true, displays an icon and the subtitle in a Row layout.
        if (hasIcon) {
            Row {
                // Displays the icon.
                Icon(icon, contentDescription = "Star")
                // Adds a spacer for a gap of 4.dp.
                Spacer(Modifier.width(4.dp))
                // Displays the subtitle with bold font and a font size of 24.sp.
                Text(
                    subTitleValue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        } else {
            // If hasIcon is false, only displays the subtitle with bold font and a font size of 24.sp.
            Text(
                subTitleValue,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

        // If hasInfo is true, displays additional info with a font size of 12.sp and a color defined by MaterialTheme.colorScheme.onSurface.
        if (hasInfo) {
            Text(
                "(16 nesta semana)",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 12.sp
            )
        }

    }
}