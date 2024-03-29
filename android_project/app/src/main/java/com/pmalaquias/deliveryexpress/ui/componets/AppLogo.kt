package com.pmalaquias.deliveryexpress.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

@Composable
fun AppLogo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
        )
        Column {
            Text(
                "Delivery",
                fontSize = 20.sp,
            )
            Text(
                "Express",
                fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                fontSize = 24.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppLogoPreview() {
    AppTheme {
        AppLogo()
    }
}