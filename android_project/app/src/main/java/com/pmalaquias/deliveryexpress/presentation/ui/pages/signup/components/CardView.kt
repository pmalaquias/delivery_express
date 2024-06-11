package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.data.models.enums.CardBrand
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme

/**
 * A Composable function that displays a card view with the given parameters.
 *
 * @param modifier The modifier to be applied to the CardView.
 * @param cardNumber The card number to be displayed. Default value is "000000000000000".
 * @param nameOwner The name of the card owner. Default value is an empty string.
 * @param expDateMonth The expiration month of the card. Default value is "00".
 * @param expDateYear The expiration year of the card. Default value is "00".
 * @param cardBrand The brand of the card. Default value is CardBrand.VISA.
 */
@Composable
fun CardView(
    modifier: Modifier = Modifier,
    cardNumber: String = "000000000000000",
    nameOwner: String = "",
    expDateMonth: String = "00",
    expDateYear: String = "00",
    ccv: String = "000",
    cardBrand: CardBrand = CardBrand.VISA,
) {

    // Determine the logo of the card brand
    val logoCardBrand: Int = when (cardBrand) {
        CardBrand.VISA -> R.drawable.visa
        CardBrand.MASTERCARD -> R.drawable.mastercard_logo
        CardBrand.AMEX -> R.drawable.american_express_logo
        CardBrand.ELO -> R.drawable.elo
        CardBrand.JCB -> R.drawable.jcb_logo
        CardBrand.DINERS_CLUB -> R.drawable.diners_club
        CardBrand.HIPERCARD -> R.drawable.hipercard_logo
        CardBrand.UNKNOWN -> TODO()
    }

    // Function to mask the card number
    @Composable
    fun maskCardNumber(cardNumber: String): String {
        return if (cardNumber.length >= 4) {
            "**** **** **** ${cardNumber.substring(cardNumber.length - 4)}"
        } else {
            stringResource(id = R.string.msg_invalid_card_number)
        }
    }

    // Function to format the expiration date
    fun expDate(expDateMonth: String, expDateYear: String): String = "$expDateMonth/$expDateYear"

    // Composable function to display the card view
    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,

            ),
    ) {
        Column(
            Modifier
                .height(200.dp)
                .width(350.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    //.height(150.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(text = stringResource(id = R.string.card_number))
                        Text(
                            text = maskCardNumber(cardNumber),
                            //fontSize = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Column(

                    modifier = Modifier.weight(1f),
                ) {
                    Column {
                        Text(text = stringResource(R.string.label_ccv))
                        Text(
                            text = ccv,
                            //fontSize = 32.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .background(
                        color = Color.White.copy(alpha = 0.8f),
                        shape = RoundedCornerShape(16.dp),
                    )
                    .graphicsLayer {
                        compositingStrategy = CompositingStrategy.Auto
                        alpha = 0.75f
                    }


            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = stringResource(id = R.string.label_card_holder_name),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light,
                            color = MaterialTheme.colorScheme.onSurface

                        )
                        Text(
                            text = nameOwner,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Column {
                        Text(
                            text = stringResource(id = R.string.label_card_expiration),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = expDate(expDateMonth, expDateYear),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Image(
                        colorFilter = ColorFilter.tint(Color.Black),
                        painter = painterResource(
                            id = logoCardBrand
                        ),
                        contentDescription = "Visa",
                        modifier = Modifier
                            .height(64.dp)
                            .width(64.dp)
                    )
                }


            }
        }
    }
}

/**
 * A preview Composable function that displays a CardView with AMEX as the card brand.
 */
@Preview
@Composable
fun CardViewPreview() {
    AppTheme {
        CardView(
            nameOwner = "William",
            cardBrand = CardBrand.AMEX,
        )
    }
}