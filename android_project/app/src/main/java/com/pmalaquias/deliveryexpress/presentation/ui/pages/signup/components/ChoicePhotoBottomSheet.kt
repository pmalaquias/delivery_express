package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pmalaquias.deliveryexpress.R

/**
 * Composable function that displays a bottom sheet with options to take a photo or select one from the gallery.
 *
 * @param onDismiss Function to be invoked when the bottom sheet is dismissed.
 * @param onTakePhotoClick Function to be invoked when the "Take a Photo" option is clicked.
 * @param onPhotoGalleryClick Function to be invoked when the "Select from Gallery" option is clicked.
 */
@Composable
fun ChoicePhotoBottomSheet(
    onDismiss: () -> Unit,
    onTakePhotoClick: () -> Unit,
    onPhotoGalleryClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)){
        ChoicePhotoBottomSheetContent(
            header = stringResource(id = R.string.header_choice_option),
            onDismiss = {
                onDismiss.invoke()
            },
            items = listOf(
                BottomSheetItem(
                    title = stringResource(id = R.string.title_take_photo),
                    icon = Icons.Outlined.PhotoCamera,
                    onClick = {
                        onTakePhotoClick.invoke()
                    }
                ),
                BottomSheetItem(
                    title = stringResource(id = R.string.title_select_gallery),
                    icon = Icons.Default.PhotoLibrary,
                    onClick = {
                        onPhotoGalleryClick.invoke()
                    }
                ),
            )
        )
    }
}

/**
 * Composable function that displays the content of the bottom sheet.
 *
 * @param onDismiss Function to be invoked when the bottom sheet is dismissed.
 * @param header The header text of the bottom sheet.
 * @param items The list of items to be displayed in the bottom sheet.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChoicePhotoBottomSheetContent(
    onDismiss: () -> Unit,
    header: String = "Choose Option",
    items: List<BottomSheetItem> = listOf(),
) {
    val skipPartiallyExpanded by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )
    val edgeToEdgeEnabled by remember { mutableStateOf(false) }
    val windowInsets = if (edgeToEdgeEnabled)
        WindowInsets(0) else BottomSheetDefaults.windowInsets

    ModalBottomSheet(
        shape = MaterialTheme.shapes.medium.copy(
            bottomStart = CornerSize(0),
            bottomEnd = CornerSize(0)
        ),
        onDismissRequest = { onDismiss.invoke() },
        sheetState = bottomSheetState,
        windowInsets = windowInsets
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = header,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            items.forEach {item ->
                ListItem(
                    modifier = Modifier.clickable {
                        item.onClick.invoke()
                    },
                    headlineContent = {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleMedium,
                        )
                    },
                    leadingContent = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                )
            }
        }
    }
}

/**
 * Data class representing an item in the bottom sheet.
 *
 * @param title The title of the item.
 * @param icon The icon of the item.
 * @param onClick Function to be invoked when the item is clicked.
 */
data class BottomSheetItem(
    val title: String = "",
    val icon: ImageVector,
    val onClick: () -> Unit
)

