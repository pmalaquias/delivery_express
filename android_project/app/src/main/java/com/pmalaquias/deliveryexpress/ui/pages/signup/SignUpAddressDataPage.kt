package com.pmalaquias.deliveryexpress.ui.pages.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

//const val FILE_NAME = "com/pmalaquias/deliveryexpress/data/state_city.json"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpAddressDeliveryPersonDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }

    var sliderPosition by remember { mutableFloatStateOf(0f) }

    var selectedState by remember { mutableStateOf<String?>(null) }
    var selectedCity by remember { mutableStateOf<String?>(null) }
    //val estadosCidades = loadEstadosCidades()

    //val estados = estadosCidades.estados.map { it.nome }
    //val cidades = estadosCidades.estados.find { it.nome == selectedState }?.cidades ?: emptyList()

    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown


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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.address_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.address_home)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.address_number)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.neighborhood)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.address_complement)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))

                // Create an Outlined Text Field
                // with icon and not expanded
                TextField(value = mSelectedText,
                    onValueChange = { mSelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
                            mTextFieldSize = coordinates.size.toSize()
                        },
                    label = { Text(stringResource(id = R.string.address_state)) },
                    trailingIcon = {
                        Icon(icon,
                            "contentDescription",
                            Modifier.clickable { mExpanded = !mExpanded })
                    })

                // Create a drop-down menu with list of cities,
                // when clicked, set the Text Field text as the city selected
                DropdownMenu(expanded = mExpanded,
                    onDismissRequest = { mExpanded = false },
                    modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
                ) {
                    mCities.forEach { label ->
                        DropdownMenuItem(onClick = {
                            mSelectedText = label
                            mExpanded = false
                        }, text = { Text(text = label) })

                    }
                }
            }

            //Spacer(modifier = Modifier.size(8.dp))

            // Create an Outlined Text Field
            // with icon and not expanded
            TextField(value = mSelectedText,
                onValueChange = { mSelectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text(stringResource(id = R.string.address_city)) },
                trailingIcon = {
                    Icon(icon, "contentDescription", Modifier.clickable { mExpanded = !mExpanded })
                })

            // Create a drop-down menu with list of cities,
            // when clicked, set the Text Field text as the city selected
            DropdownMenu(expanded = mExpanded,
                onDismissRequest = { mExpanded = false },
                modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
            ) {
                mCities.forEach { label ->
                    DropdownMenuItem(onClick = {
                        mSelectedText = label
                        mExpanded = false
                    }, text = { Text(text = label) })

                }
            }

            //Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(id = R.string.maximum_display_distance),
                //fontSize = 24.sp
            )
            //Spacer(modifier = Modifier.size(8.dp))
            Column(
                modifier = modifier, horizontalAlignment = Alignment.End
            ) {
                Text(text = ("%.2f").format(sliderPosition) + " km")
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    valueRange = 0f..100f,
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
fun SignUpAddressDataPagePreview() {
    AppTheme {
        SignUpAddressDeliveryPersonDataPage()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpAddressClientDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }

    var sliderPosition by remember { mutableFloatStateOf(0f) }

    var selectedState by remember { mutableStateOf<String?>(null) }
    var selectedCity by remember { mutableStateOf<String?>(null) }
    //val estadosCidades = loadEstadosCidades()

    //val estados = estadosCidades.estados.map { it.nome }
    //val cidades = estadosCidades.estados.find { it.nome == selectedState }?.cidades ?: emptyList()


    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown


    Scaffold(Modifier.padding(16.dp), topBar = { AppBarClient() }) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = stringResource(id = R.string.address_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.address_home)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.address_number)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = modifier.padding(8.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.neighborhood)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(
                    value = text,
                    onValueChange = { /*TODO*/ },
                    label = { Text(stringResource(id = R.string.address_complement)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))

                // Create an Outlined Text Field
                // with icon and not expanded
                //ESTADO
                TextField(value = selectedState ?: "",
                    onValueChange = { selectedState = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
                            mTextFieldSize = coordinates.size.toSize()
                        },
                    label = { Text(stringResource(id = R.string.address_state)) },
                    trailingIcon = {
                        Icon(icon,
                            "contentDescription",
                            Modifier.clickable { mExpanded = !mExpanded })
                    })

                // Create a drop-down menu with list of cities,
                // when clicked, set the Text Field text as the city selected
                DropdownMenu(expanded = mExpanded,
                    onDismissRequest = { mExpanded = false },
                    modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
                ) {
                    mCities.forEach { label ->
                        DropdownMenuItem(onClick = {
                            mSelectedText = label
                            mExpanded = false
                        }, text = { Text(text = label) })

                    }
                }
            }

            //Spacer(modifier = Modifier.size(8.dp))

            // Create an Outlined Text Field
            // with icon and not expanded
            //CIDADE
            TextField(value = mSelectedText,
                onValueChange = { mSelectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to
                        // the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
                label = { Text(stringResource(id = R.string.address_city)) },
                trailingIcon = {
                    Icon(icon, "contentDescription", Modifier.clickable { mExpanded = !mExpanded })
                })

            // Create a drop-down menu with list of cities,
            // when clicked, set the Text Field text as the city selected
            DropdownMenu(expanded = mExpanded,
                onDismissRequest = { mExpanded = false },
                modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
            ) {
                mCities.forEach { label ->
                    DropdownMenuItem(onClick = {
                        mSelectedText = label
                        mExpanded = false
                    }, text = { Text(text = label) })

                }
            }
        }


        //Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(id = R.string.maximum_display_distance),
            //fontSize = 24.sp
        )
        //Spacer(modifier = Modifier.size(8.dp))
        Column(
            modifier = modifier, horizontalAlignment = Alignment.End
        ) {
            Text(text = ("%.2f").format(sliderPosition) + " km")
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..100f,
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


@Preview(showBackground = true)
@Composable
fun SignUpAddressClientDataPagePreview() {
    AppTheme {
        SignUpAddressClientDataPage()
    }
}

@Composable
fun CustomDropdownMenu(
    label: String,
    items: List<String>,
    selectedItem: String?,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column(modifier = modifier) {
        TextField(value = selectedItem ?: "",
            onValueChange = {},
            label = { Text(label) },
            enabled = enabled,
            trailingIcon = {
                Icon(icon,
                    "contentDescription",
                    Modifier.clickable { if (enabled) expanded = !expanded })
            },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> textFieldSize = coordinates.size.toSize() },
            readOnly = true
        )
        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            items.forEach { item ->
                DropdownMenuItem(onClick = {
                    onItemSelected(item)
                    expanded = false
                }, text = { Text(text = label) })

            }
        }
    }
}

