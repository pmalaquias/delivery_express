package com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SwapCalls
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.unit.dp
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * This composable function creates a navigation drawer with a list of menu items.
 *
 * @param selectedItem The index of the currently selected menu item.
 * @param scope The CoroutineScope in which to launch the coroutine that handles drawer state changes.
 * @param drawerState The current state of the drawer (open or closed).
 */
@Composable
fun NavigateDrawerContent(selectedItem: Int, scope: CoroutineScope, drawerState: DrawerState) {

    // The index of the currently selected menu item, saved across configuration changes.
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    // The list of menu items to display in the drawer.
    val menuItems = listOf(
        R.string.menu_item_start,
        R.string.menu_item_deliveries_progress,
        R.string.menu_item_transactions_completed,
        R.string.menu_item_help_support,
        R.string.menu_item_about,
        R.string.menu_item_exit
    )

    // The list of icons to display next to each menu item.
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.SwapCalls,
        Icons.AutoMirrored.Filled.ListAlt,
        Icons.Filled.Settings,
        Icons.AutoMirrored.Filled.Help,
        Icons.AutoMirrored.Filled.ExitToApp
    )

    // The main content of the drawer.
    ModalDrawerSheet {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.9f))
                .fillMaxWidth()
                .height(200.dp),
        ){
            // The header of the drawer, containing an image and some text.
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
        } // End of the box
        Spacer(modifier = Modifier.size(8.dp))

        // Create a NavigationDrawerItem for each menu item.
        menuItems.forEachIndexed { index, label ->
            NavigationDrawerItem(
                icon = { Icon(icons[index], contentDescription = null) },
                label = {
                    Text(
                        text = stringResource(id = label),
                        fontWeight = if (index == selectedItemIndex) FontWeight.Bold else FontWeight.Normal
                    )
                },
                selected = index == selectedItemIndex,
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
