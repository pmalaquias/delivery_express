package com.pmalaquias.deliveryexpress.presentation.ui.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components.BottomSheetContent
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components.MapScreen
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components.NavigateDrawerContent
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import kotlinx.coroutines.launch


/**
 * This composable function creates the home page of the application.
 *
 * The home page consists of a navigation drawer, a top app bar, a floating action button, and a modal bottom sheet.
 * The navigation drawer contains a list of menu items, and its state is managed by a `DrawerState` object.
 * The top app bar contains a menu button that opens or closes the navigation drawer, and a notifications button.
 * The floating action button is used to toggle the visibility of the modal bottom sheet.
 * The modal bottom sheet contains additional content that can be shown or hidden by the user.
 *
 * @param modifier The modifier to be applied to the layout.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) {

    // The state of the modal bottom sheet.
    val sheetState = rememberModalBottomSheetState()
    // The CoroutineScope in which to launch the coroutine that handles drawer state changes.
    val scope = rememberCoroutineScope()
    // The visibility state of the bottom sheet.
    var showBottomSheet by remember { mutableStateOf(false) }
    // The state of the navigation drawer.
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    // The index of the currently selected menu item in the navigation drawer.
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    // The navigation drawer.
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // The content of the navigation drawer.
            NavigateDrawerContent(selectedItemIndex, scope, drawerState)
        },

        ) {
        // The main content of the home page.
        Scaffold(topBar = {
            // The top app bar.
            TopAppBar(title = { Text(text = stringResource(id = R.string.title_home)) },
                navigationIcon = {
                // The menu button.
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
            }, actions = {
                // The notifications button.
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Notifications, contentDescription = "Notificações")

                }
            })
        }, floatingActionButton = {
            // The floating action button.
            if (drawerState.isClosed) {
                ExtendedFloatingActionButton(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.8f),
                    icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                    text = { Text(stringResource(id = R.string.button_new_delivery)) },
                    onClick = {
                        // Toggle the visibility of the bottom sheet.
                        showBottomSheet = !showBottomSheet
                    }
                )
            }
        }

        ) { innerPadding ->
            // The main content of the home page.
            Column(modifier = modifier.padding(innerPadding)) {
                // The map screen.
                MapScreen()

                // The modal bottom sheet.
                if (showBottomSheet) {
                    ModalBottomSheet(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerLow.copy(alpha = 0.8f),
                        onDismissRequest = {
                            // Toggle the visibility of the bottom sheet.
                            showBottomSheet = !showBottomSheet
                        }, sheetState = sheetState
                    ) {
                        // The content of the bottom sheet.
                        BottomSheetContent()
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    AppTheme {
        HomePage()
    }
}
