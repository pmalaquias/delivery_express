package com.pmalaquias.deliveryexpress.ui.pages.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.star
import com.pmalaquias.deliveryexpress.ui.componets.RoundedPolygonShape
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun InfiniteCarousel(items: Map<String, String>, modifier: Modifier = Modifier) {

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val hexagon = remember {
        RoundedPolygon.star(
            6,
            rounding = CornerRounding(0.2f)
        )
    }

    val clip = remember(hexagon) {
        RoundedPolygonShape(polygon = hexagon)
    }

    Box {
        LazyRow(state = listState) {
            items(items.size) { index ->

                val message = items.keys.toList()[index]
                val description = items.values.toList()[index]

                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .size(320.dp, 250.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                ) {
                    Column(
                        modifier = modifier
                            .padding(16.dp)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = message,
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(
                            text = description,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            coroutineScope.launch {
                while (true) {
                    delay(3000) // Tempo de espera entre as transições dos itens

                    if (listState.firstVisibleItemIndex == items.size - 1) {
                        listState.animateScrollToItem(0)
                    } else {
                        listState.animateScrollToItem((listState.firstVisibleItemIndex + 1) % items.size)
                    }
                }
            }
        }

        // Indicadores de página
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(items.size) { index ->

                PageIndicator(
                    selected = index == ((listState.firstVisibleItemIndex) % (items.size)),
                    shape = clip
                )
            }

        }
    }
}

@Composable
fun rememberCarouselIndicatorsState(
    pageCount: Int
): CarouselIndicatorsState {
    return remember {
        CarouselIndicatorsState(pageCount)
    }
}

@Composable
fun PageIndicator(selected: Boolean, shape: Shape) {
    val color = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray
    val size = if (selected) 12.dp else 8.dp

    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .size(size)
            .clip(shape)
            .background(color)
    )
}

class CarouselIndicatorsState(var currentPage: Int)