package com.pmalaquias.deliveryexpress.ui.pages.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.pages.signup.CardBrand
import com.pmalaquias.deliveryexpress.ui.pages.signup.VehicleColor
import com.pmalaquias.deliveryexpress.ui.pages.signup.VehicleType
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme


@Composable
fun <T> RadioOptionTypeCustom(
    value: T,
    valueGroup: T? = null,
    onValueChange: (T) -> Unit,
    label: String,
    img: Painter,
    imgSize: Dp = 40.dp,
    selectImgSize: Dp = 60.dp,
    modifier: Modifier = Modifier
) {
    val isSelected = value == valueGroup

    Card(
        onClick = { onValueChange(value) },
        modifier = modifier.size(height = 95.dp, width = 112.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = img,
                contentDescription = null,
                modifier = Modifier.size(if (isSelected) selectImgSize else imgSize),
                colorFilter = if (isSelected) null else ColorFilter.tint(Color(0xFF534341))
            )
            Text(
                text = label,
                color = if (isSelected) Color.Unspecified else Color(0xFF534341),
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun RadioOptionTypeCustomPreview() {
    AppTheme {
        RadioOptionTypeCustom(
            value = VehicleType.Car,
            onValueChange = { /*TODO*/ },
            label = stringResource(id = R.string.vehicle_car),
            img = painterResource(id = R.drawable.car),
            modifier = Modifier.fillMaxWidth()

        )
    }
}


@Composable
fun <T> RadioOptionTypeColorCustom(
    value: T,
    valueGroup: T? = null,
    onValueChange: (T) -> Unit,
    imgSize: Dp = 40.dp,
    color: Color = Color.White,
    selectImgSize: Dp = 60.dp,
    modifier: Modifier = Modifier
) {

    val isSelected = value == valueGroup
    val elevation = if (isSelected) 8.dp else 2.dp

    ElevatedCard(
        elevation = CardDefaults.cardElevation(elevation),
        onClick = { onValueChange(value) },
        modifier = modifier.size(height = 50.dp, width = 50.dp)
    ) {
        Box(
            modifier = modifier
                .background(color = color)
                .fillMaxHeight()
                .fillMaxWidth()
                .border(
                    width = if (isSelected) 3.dp else 1.dp,
                    color = if (isSelected) MaterialTheme.colorScheme.primary else Color.LightGray,
                    RoundedCornerShape(12.dp),
                ),
        ) {
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RadioOptionTypeColorCustomPreview() {
    AppTheme {
        RadioOptionTypeColorCustom<VehicleColor>(
            value = VehicleColor.Green,
            onValueChange = { /*TODO*/ },
            color = Color.Green,

            )
    }
}

@Composable
fun <T> RadioOptionCardBrandCustom(
    value: T,
    valueGroup: T? = null,
    onValueChange: (T) -> Unit,
    img: Painter,
    imgSize: Dp = 40.dp,
    color: Color = Color.White,
    selectImgSize: Dp = 60.dp,
    modifier: Modifier = Modifier
) {

    val isSelected = value == valueGroup
    val elevation = if (isSelected) 8.dp else 2.dp

    ElevatedCard(
        elevation = CardDefaults.cardElevation(elevation),
        onClick = { onValueChange(value) },
    ) {
        Box(
            modifier = modifier
                .size(height = 50.dp, width = 80.dp)
                .background(color = if (isSelected) color else Color(0x629E9E9E))
        ) {
            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = img,
                    contentDescription = null,
                    modifier = Modifier.size(if (isSelected) selectImgSize else imgSize),
                    colorFilter = if (isSelected) null else ColorFilter.tint(Color(0xFF534341))
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RadioOptionCardBrandCustomPreview() {
    AppTheme {
        RadioOptionCardBrandCustom<CardBrand>(
            value = CardBrand.VISA,
            onValueChange = { /*TODO*/ },
            img = painterResource(id = R.drawable.visa),
            color = Color(0xFF2566AF)
        )
    }
}