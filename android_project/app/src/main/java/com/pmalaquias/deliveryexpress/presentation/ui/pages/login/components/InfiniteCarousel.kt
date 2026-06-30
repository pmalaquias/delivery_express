package com.pmalaquias.deliveryexpress.presentation.ui.pages.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
import com.pmalaquias.deliveryexpress.presentation.ui.componets.RoundedPolygonShape
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@Composable
fun InfiniteCarousel(items: Map<String, String>, modifier: Modifier = Modifier) {
    val itemList = remember(items) { items.toList() }
    if (itemList.isEmpty()) return

    // Para um efeito infinito, usamos um número muito grande de páginas
    val pageCount = Int.MAX_VALUE
    val startIndex = (pageCount / 2) - ((pageCount / 2) % itemList.size)
    val pagerState = rememberPagerState(initialPage = startIndex) { pageCount }

    val hexagon = remember {
        RoundedPolygon.star(
            6,
            rounding = CornerRounding(0.2f)
        )
    }

    val clip = remember(hexagon) {
        RoundedPolygonShape(polygon = hexagon)
    }

    // Efeito de auto-scroll
    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000)
            yield() // Garante que a corrotina possa ser cancelada se necessário
            if (!pagerState.isScrollInProgress) {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }
    }

    Box(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 48.dp),
            pageSpacing = 16.dp
        ) { page ->
            val actualIndex = page % itemList.size
            val (message, description) = itemList[actualIndex]

            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(250.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
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

        // Indicadores de página
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(itemList.size) { index ->
                PageIndicator(
                    selected = (pagerState.currentPage % itemList.size) == index,
                    shape = clip
                )
            }
        }
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
