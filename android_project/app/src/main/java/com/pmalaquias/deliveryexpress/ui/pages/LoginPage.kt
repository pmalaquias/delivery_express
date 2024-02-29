package com.pmalaquias.deliveryexpress.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pmalaquias.deliveryexpress.R
import java.util.Locale

enum class DeliveryScreen {
    Login,
    SignUp,
    Home
}

@Composable
fun DeliveryApp(){
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()

    // Get the name of the current screen
    val currentScreen = DeliveryScreen.valueOf(
        backStackEntry?.destination?.route ?: DeliveryScreen.Login.name
    )

    NavHost(navController = navController, startDestination = DeliveryScreen.Login.name){
        composable(DeliveryScreen.Login.name){
            LoginPage(
                onSignUpButtonClicked = {
                    navController.navigate(DeliveryScreen.SignUp.name)
                }
            )
        }
        composable(DeliveryScreen.SignUp.name){
            SignUpPage(
                onCancelButtonClicked = {
                    navController.popBackStack()
                },
                onNextButtonClicked = {
                    navController.navigate(DeliveryScreen.Home.name)
                }
            )
        }


    }
}

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onSignUpButtonClicked: () -> Unit = {}
) {
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
            )
            Column {
                Text(
                    "Delivery",
                    fontSize = 20.sp,
                )
                Text(
                    "Express",
                    fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                    fontSize = 24.sp,
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.login_message))
            Spacer(modifier = Modifier.size(16.dp))
            TextField(
                value = text,
                onValueChange = { /*TODO*/ },
                label = { Text(stringResource(R.string.email_label)) },
                modifier = modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.size(16.dp))
            TextField(
                value = text,
                onValueChange = { /*TODO*/ },
                label = { Text(stringResource(R.string.password_label)) },
                modifier = modifier.fillMaxWidth(),

                trailingIcon = {
                    TextButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Outlined.Visibility, "Visibility")
                    }
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = stringResource(R.string.forgot_your_password_message))
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.forgot_password_button))
                }
            }
            Button(onClick = { /*TODO*/ },modifier = modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.login_button).uppercase(Locale.ROOT))
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(R.string.signup_message))
                TextButton(onClick = onSignUpButtonClicked) {
                    Text(text = stringResource(R.string.signup_button))

                }
            }
        }

    }
}