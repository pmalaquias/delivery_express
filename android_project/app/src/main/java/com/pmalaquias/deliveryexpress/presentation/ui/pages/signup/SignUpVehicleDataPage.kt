package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.RadioOptionTypeColorCustom
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.RadioOptionTypeCustom
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

enum class VehicleType {
    Car, PickupTruck, Truck, Motorcycle, Bicycle, Other
}

enum class VehicleColor {
    White, Gray, Red, Blue, Green, Black, Yellow, Other
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpVehicleDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }

    var vehicleGroup: VehicleType? by rememberSaveable { mutableStateOf(VehicleType.Car) }
    var colorGroup: VehicleColor? by rememberSaveable { mutableStateOf(VehicleColor.White) }

    val valueVehicleTypeChangedHandler: (VehicleType?) -> Unit = { value: VehicleType? ->
        vehicleGroup = value
    }

    val valueVehicleColorChangedHandler: (VehicleColor?) -> Unit = { value: VehicleColor? ->
        colorGroup = value
    }

    val alpha = 0.6f

    val brush = Brush.sweepGradient(
        listOf(
            Color.Red.copy(alpha = alpha),
            Color(0xffff812a).copy(alpha = alpha),
            Color.Yellow.copy(alpha = alpha),
            Color.Green.copy(alpha = alpha),
            Color.Blue.copy(alpha = alpha),
            Color(0xff4e007f).copy(alpha = alpha),
            Color(0xff9a00ce).copy(alpha = alpha)
        )
    )

    var isClicked by remember { mutableStateOf(false) }

    Scaffold(Modifier.padding(16.dp), topBar = { AppBarDeliveryPerson() }) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        text = stringResource(id = R.string.vehicle_data),
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))

                Text(text = stringResource(id = R.string.vehicle_type))
                Spacer(modifier = modifier.size(8.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RadioOptionTypeCustom(
                        value = VehicleType.Car,
                        valueGroup = vehicleGroup,
                        onValueChange = valueVehicleTypeChangedHandler,
                        label = stringResource(id = R.string.vehicle_car),
                        img = painterResource(id = R.drawable.car),
                        modifier = modifier
                    )
                    RadioOptionTypeCustom(
                        value = VehicleType.PickupTruck,
                        valueGroup = vehicleGroup,
                        onValueChange = valueVehicleTypeChangedHandler,
                        label = stringResource(id = R.string.vehicle_pickup_truck),
                        img = painterResource(id = R.drawable.pickup_truck),
                        modifier = modifier
                    )
                    RadioOptionTypeCustom(
                        value = VehicleType.Truck,
                        valueGroup = vehicleGroup,
                        onValueChange = valueVehicleTypeChangedHandler,
                        label = stringResource(id = R.string.vehicle_truck),
                        img = painterResource(id = R.drawable.truck),
                        modifier = modifier
                    )
                }
                Spacer(modifier = modifier.size(8.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RadioOptionTypeCustom(
                        value = VehicleType.Motorcycle,
                        valueGroup = vehicleGroup,
                        onValueChange = valueVehicleTypeChangedHandler,
                        label = stringResource(id = R.string.vehicle_motorcycle),
                        img = painterResource(id = R.drawable.motorcycle),
                        modifier = modifier
                    )
                    RadioOptionTypeCustom(
                        value = VehicleType.Bicycle,
                        valueGroup = vehicleGroup,
                        onValueChange = valueVehicleTypeChangedHandler,
                        label = stringResource(id = R.string.vehicle_bicycle),
                        img = painterResource(id = R.drawable.bicycle),
                        modifier = modifier
                    )
                    RadioOptionTypeCustom(
                        value = VehicleType.Other,
                        valueGroup = vehicleGroup,
                        onValueChange = valueVehicleTypeChangedHandler,
                        label = stringResource(id = R.string.vehicle_other),
                        img = painterResource(id = R.drawable.other_vehicle),
                        modifier = modifier
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))

                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.vehicle_model)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))

                // TODO: Add vehicle color
                Text(text = stringResource(id = R.string.vehicle_color))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    RadioOptionTypeColorCustom(
                        valueGroup = colorGroup,
                        value = VehicleColor.White,
                        onValueChange = valueVehicleColorChangedHandler,
                        color = Color.White,
                    )
                    RadioOptionTypeColorCustom(
                        valueGroup = colorGroup,
                        value = VehicleColor.Gray,
                        onValueChange = valueVehicleColorChangedHandler,
                        color = Color.Gray,
                    )
                    RadioOptionTypeColorCustom(
                        valueGroup = colorGroup,
                        value = VehicleColor.Black,
                        onValueChange = valueVehicleColorChangedHandler,
                        color = Color.Black,
                    )
                    RadioOptionTypeColorCustom(
                        valueGroup = colorGroup,
                        value = VehicleColor.Red,
                        onValueChange = valueVehicleColorChangedHandler,
                        color = Color.Red,
                    )
                    RadioOptionTypeColorCustom(
                        valueGroup = colorGroup,
                        value = VehicleColor.Blue,
                        onValueChange = valueVehicleColorChangedHandler,
                        color = Color.Blue,
                    )
                    ElevatedCard(
                        modifier = modifier.size(height = 50.dp, width = 50.dp),
                    ) {
                        Box(
                            modifier = modifier
                                .background(brush)
                                .fillMaxHeight()
                                .fillMaxWidth()

                        ) {
                            IconButton(
                                onClick = {
                                    colorGroup = VehicleColor.Other
                                    isClicked = true

                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = modifier.size(50.dp)
                                )
                            }
                        }
                    }
                }
                if (isClicked) {
                    BasicAlertDialog(
                        onDismissRequest = { isClicked = false },
                        content = {
                            ColorPicker(
                                onCancelButtonClicked = {
                                    isClicked = false
                                    colorGroup =  VehicleColor.White
                                },
                                onContinueButtonClicked = { isClicked = false }

                            )
                        }
                    )
                }

                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.license_plate)) },
                    modifier = modifier.fillMaxWidth(),
                )

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
fun SignUpVehicleDataPagePreview() {
    AppTheme {
        SignUpVehicleDataPage()
    }
}

@Composable
fun ColorPicker(
    modifier: Modifier = Modifier,
    onColorSelected: (Color) -> Unit = { },
    onContinueButtonClicked: () -> Unit = { },
    onCancelButtonClicked: () -> Unit = { },
) {

    OutlinedCard() {
        Column(
            modifier = modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Select Other Color",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = modifier.size(8.dp))

            //TODO: Make color Piker

            Spacer(modifier = modifier.size(8.dp))
            Row(horizontalArrangement = Arrangement.End, modifier = modifier.fillMaxWidth()) {
                TextButton(onClick = onCancelButtonClicked) {
                    Text(text = stringResource(id = R.string.cancel_button))
                }
                TextButton(onClick = onContinueButtonClicked) {
                    Text(text = stringResource(id = R.string.continue_button))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorPickerPreview() {
    AppTheme {
        ColorPicker()
    }
}
