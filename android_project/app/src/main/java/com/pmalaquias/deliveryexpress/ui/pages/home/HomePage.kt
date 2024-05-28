package com.pmalaquias.deliveryexpress.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Outbox
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SwapCalls
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    //Remember Clicked index state
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigateDrawerContent(selectedItemIndex, scope, drawerState)
            }
        },

        ) {
        // Screen content


        Scaffold(topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.title_home)) },
                navigationIcon = {
                IconButton(onClick = {

                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                        //drawerState.open()
                        //showDrawer = true
                    }
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
                }
            }, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Notifications, contentDescription = "Notificações")

                }
            })
        }, floatingActionButton = {
            if (drawerState.isClosed) {
                ExtendedFloatingActionButton(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.8f),
                    icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                    text = { Text(stringResource(id = R.string.button_new_delivery)) },
                    onClick = {
                        showBottomSheet = !showBottomSheet
                    }
                )
            }
        }

        ) { innerPadding ->
            Column(modifier = modifier.padding(innerPadding)) {
                // Screen content
                MapScreen()

                if (showBottomSheet) {
                    ModalBottomSheet(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerLow.copy(alpha = 0.8f),
                        onDismissRequest = {
                            showBottomSheet = !showBottomSheet
                        }, sheetState = sheetState
                    ) {
                        // Sheet content
                        BottomSheetContent()
                    }
                }
            }

        }
    }


}

@Composable
fun BottomSheetContent(
    height: Dp = 300.dp,
    backgroundColor: Color = Color.White,
    scrimColor: Color = Color.Black
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            //.background(MaterialTheme.colorScheme.surfaceContainerLow.copy(alpha = 0.8f)),
    ) {
        Text("Boa Tarde,")
        Text(
            text = "Supermercado Nova Europa",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colorScheme.primary

        )
        Spacer(modifier = Modifier.size(16.dp))

        Column {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Filled.Outbox, contentDescription = null)
                Spacer(modifier = Modifier.size(8.dp))
                Text(stringResource(id = R.string.button_new_delivery))
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Filled.Receipt, contentDescription = null)
                Spacer(modifier = Modifier.size(8.dp))
                Text(stringResource(id = R.string.button_latest_transactions))
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Composable
fun NavigateDrawerContent(selectedItem: Int, scope: CoroutineScope, drawerState: DrawerState) {

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    val menuItems = listOf(
        R.string.menu_item_start,
        R.string.menu_item_deliveries_progress,
        R.string.menu_item_transactions_completed,
        R.string.menu_item_help_support,
        R.string.menu_item_about,
        R.string.menu_item_exit
    )

    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.SwapCalls,
        Icons.AutoMirrored.Filled.ListAlt,
        Icons.Filled.Settings,
        Icons.AutoMirrored.Filled.Help,
        Icons.Filled.Info,
        Icons.AutoMirrored.Filled.ExitToApp
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.9f))
                .fillMaxWidth()
                .height(200.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Box(modifier = Modifier.size(100.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.unknown_person),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Transparent, CircleShape)
                            .background(MaterialTheme.colorScheme.secondary)
                    )
                }
                Text(
                    text = "Supermercado Nova Europa",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "Avenida Brasil, 123",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Normal,
                )
            }
        }


        Spacer(modifier = Modifier.size(8.dp))

        menuItems.forEachIndexed { index, label ->
            NavigationDrawerItem(
                icon = { Icon(icons[index], contentDescription = null) },
                label = {
                    Text(
                        text = stringResource(id = label),
                        fontWeight = if (index == selectedItemIndex) FontWeight.Bold else FontWeight.Normal
                    )
                },
                selected = index == selectedItemIndex, // Set first item as selected
                onClick = {
                    selectedItemIndex = index
                    scope.launch {
                        drawerState.close()
                    }

                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)

            )

        }
    }
}

@Composable
fun MapScreen() {
    val atasehir = LatLng(-20.385556, -43.508056)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(atasehir, 15f)
    }

    val uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = false))
    }
    val properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }


    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings,
    )
}

@Preview(showBackground = true)
@Composable
fun NavigateDrawerContentPreview() {
    AppTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        NavigateDrawerContent(selectedItemIndex, scope, drawerState)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    AppTheme {
        BottomSheetContent()
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    AppTheme {
        HomePage()
    }
}
