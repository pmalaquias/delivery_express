package com.pmalaquias.deliveryexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pmalaquias.deliveryexpress.presentation.ui.pages.login.DeliveryApp
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
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
