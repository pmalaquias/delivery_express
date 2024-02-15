package com.pmalaquias.deliveryexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pmalaquias.deliveryexpress.ui.pages.LoginPage
import com.pmalaquias.deliveryexpress.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                App()

            }
        }
    }
}

@Composable
fun App( modifier: Modifier = Modifier) {
    LoginPage()
}

@Preview(showBackground = true )
@Composable
fun GreetingPreview() {
    AppTheme {
        Surface {
            App()
        }
    }
}