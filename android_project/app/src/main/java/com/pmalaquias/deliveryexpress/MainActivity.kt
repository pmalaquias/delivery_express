package com.pmalaquias.deliveryexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pmalaquias.deliveryexpress.presentation.ui.pages.DeliveryApp
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme

/**
 *   The main activity of the Delivery Express app.
 *  This activity is responsible for launching the initial screen and handling
 *  user interactions.
 *
 *  @project DeliveryExpress
 *  @author Pedro Igor
 *  @version 1.0
 * */
class MainActivity : ComponentActivity() {

    /**
     * Initializes the activity and sets up the UI elements.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                DeliveryApp()

            }
        }
    }
}
