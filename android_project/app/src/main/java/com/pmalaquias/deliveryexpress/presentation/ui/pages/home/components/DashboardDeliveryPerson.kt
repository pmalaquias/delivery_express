package com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryPersonStatus

/**
 * A composable function that displays a dashboard.
 *
 * The dashboard includes a greeting, a status dropdown, information cards, and a performance chart button.
 */
@Composable
fun Dashboard() {
    // A boolean value that determines if the status dropdown is expanded.
    var expanded by remember { mutableStateOf(false) }

    // A string value that stores the selected status.
    var selectedText by remember { mutableStateOf("Status") }

    // An icon that changes based on the expanded state of the status dropdown.
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown

    // A Column layout that fills the maximum width and height and has a padding of 16.dp.
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // A Column layout that contains the greeting and status dropdown.
        Column() {
            // A Row layout that contains the greeting and status dropdown.
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // A Column layout that contains the greeting.
                Column {
                    Text(stringResource(id = R.string.info_good_afternoon) + "!")
                    Text(
                        stringResource(id = R.string.label_hello) + ", " + "Pedro",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                // A Column layout that contains the status dropdown.
                Column(
                    modifier = Modifier, horizontalAlignment = Alignment.End
                ) {
                    Text("Status")
                    Box(
                    ) {
                        // A Row layout that contains the selected status and an icon button that expands or collapses the dropdown.
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = selectedText,
                                color = if (selectedText == "Status") Color.Gray else Color.Black,
                                fontWeight = if (selectedText == "Status") FontWeight.Light else FontWeight.Bold

                            )
                            IconButton(onClick = { expanded = true }) {
                                Icon(icon, contentDescription = "Status")
                            }
                        }
                        // A DropdownMenu that contains the status options.
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                        ) {
                            DeliveryPersonStatus.entries.forEach { item ->
                                DropdownMenuItem(text = { Text(text = item.name) }, onClick = {
                                    expanded = false
                                    selectedText = item.name
                                })
                            }
                        }
                    }
                }

            }

            // A Column layout that contains the information cards.
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // An InfoCardPanel1 that displays the available balance.
                InfoCardPanel1(
                    titleLabel = stringResource(id = R.string.label_available_balance),
                )

                Spacer(modifier = Modifier.width(16.dp))
                // A Row layout that contains two InfoCardPanel2s.
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .weight(1f)
                    ) {
                        // An InfoCardPanel2 that displays the number of deliveries completed.
                        InfoCardPanel2(
                            titleLabel = stringResource(id = R.string.label_deliveries_completed),
                            subTitleValue = "357",
                            hasInfo = true,
                        )

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .weight(1f)
                    ) {
                        // An InfoCardPanel2 that displays the review score.
                        InfoCardPanel2(
                            titleLabel = stringResource(id = R.string.label_my_reviews),
                            subTitleValue = "4.5",
                            hasIcon = true,
                            icon = Icons.Rounded.Star,
                        )
                    }
                }
            }

            // A Row layout that contains the week summary title and date range.
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(stringResource(id = R.string.title_week_summary))
                Text("(26 jan - 01 fev)")
            }


        }
        // A Button that navigates to the performance charts.
        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.BarChart, contentDescription = "Chart")
            Spacer(modifier = Modifier.width(8.dp))
            Text(stringResource(id = R.string.button_performance_charts))
        }
    }
}