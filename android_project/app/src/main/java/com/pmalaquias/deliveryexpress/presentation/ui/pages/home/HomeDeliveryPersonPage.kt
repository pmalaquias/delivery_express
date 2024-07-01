package com.pmalaquias.deliveryexpress.presentation.ui.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components.Dashboard
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components.MapScreen
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components.NavigateDrawerContent
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import kotlinx.coroutines.launch

/**
 * A composable function that displays the home page for a delivery person.
 *
 * This page includes a navigation drawer, a top app bar, and a tab row that switches between a dashboard and a map screen.
 *
 * @OptIn(ExperimentalMaterial3Api::class) Indicates that this function uses experimental APIs from Material 3.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDeliveryPersonPage() {
    //TODO:Implement viewModel

    // The CoroutineScope in which to launch the coroutine that handles drawer state changes.
    val scope = rememberCoroutineScope()
    // The state of the navigation drawer. Initially, the drawer is closed.
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    // The index of the currently selected menu item in the navigation drawer. Initially, the first item is selected.
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    // The index of the currently selected tab. Initially, the first tab is selected.
    var state by remember { mutableIntStateOf(0) }
    // The titles of the tabs.
    val titles = listOf(
        stringResource(id = R.string.title_my_dashboard),
        stringResource(id = R.string.title_map)
    )

    // A ModalNavigationDrawer that contains the navigation drawer content.
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // The content of the navigation drawer.
            NavigateDrawerContent(selectedItemIndex, scope, drawerState)
        },
    ) {
        // A Scaffold that contains the top app bar and the main content.
        Scaffold(
            topBar = {
                // The top app bar.
                TopAppBar(title = { Text(text = stringResource(id = R.string.title_home)) },
                    navigationIcon = {
                        // The menu button. When clicked, it toggles the state of the navigation drawer.
                        IconButton(onClick = {

                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        // The notifications button.
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Notifications, contentDescription = "Notificações")
                        }
                    })
            },

            ) { innerPadding ->
            // The main content.
            Column(modifier = Modifier.padding(innerPadding)) {
                // A PrimaryTabRow that contains the tabs.
                PrimaryTabRow(selectedTabIndex = state) {
                    titles.forEachIndexed { index, title ->
                        // A Tab for each title. When clicked, it updates the selected tab index.
                        Tab(selected = state == index,
                            onClick = { state = index },
                            text = {
                                Text(
                                    text = title,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        )
                    }
                }
                // Depending on the selected tab index, it displays either the Dashboard or the MapScreen.
                if (state == 0) Dashboard() else MapScreen()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeDeliveryPersonPagePreview() {
    AppTheme {
        HomeDeliveryPersonPage()
    }
}

