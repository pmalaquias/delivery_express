package com.pmalaquias.deliveryexpress.presentation.ui.pages.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

/**
 * This composable function creates a Google Map screen.
 *
 * The map is centered on a specific location (Atasehir) and zoomed in to a specific level.
 * The map's UI settings and properties are also configured.
 */
@Composable
fun MapScreen() {
    // The coordinates for the location to center the map on (Atasehir).
    val atasehir = LatLng(-20.385556, -43.508056)

    // The camera position state for the map, centered on Atasehir and zoomed in to level 15.
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(atasehir, 15f)
    }

    // The UI settings for the map, with zoom controls disabled.
    val uiSettings by remember {
        mutableStateOf(MapUiSettings(zoomControlsEnabled = false,
            myLocationButtonEnabled = true,
            compassEnabled = true,
            scrollGesturesEnabled = true,
            tiltGesturesEnabled = true,
            zoomGesturesEnabled = true))
    }

    // The properties for the map, with the map type set to normal.
    val properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }

    // The Google Map itself, filling the maximum size available.
    // The camera position, properties, and UI settings are applied to the map.
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
        uiSettings = uiSettings,
    )
}