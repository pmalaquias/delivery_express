package com.pmalaquias.deliveryexpress.presentation.ui.pages.login

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.componets.AppLogo
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.HomePage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.login.components.*
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.*
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import com.pmalaquias.deliveryexpress.presentation.viewModel.login.LoginViewModel
import java.util.Locale

enum class DeliveryScreen {
    Login,
    SignUpPersonalDeliveryManData,
    SignUpPersonalClientData,
    SignUpAccessDeliveryPersonData,
    SignUpAccessClientData,
    SignUpAddressDeliveryPersonData,
    SignUpAddressClientData,
    SignUpVehicleDeliveryPersonData,
    SignUpDeliveryData,
    SignUpPaymentDeliveryPersonData,
    SignUpPaymentClientData,
    Home
}

@Composable
fun DeliveryApp() {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()

    // Get the name of the current screen
    val currentScreen = DeliveryScreen.valueOf(
        backStackEntry?.destination?.route ?: DeliveryScreen.Login.name
    )


    var pageState: DeliveryScreen by rememberSaveable { mutableStateOf(DeliveryScreen.SignUpPersonalDeliveryManData) }

    val valuePageDeliveryChangeHandler: (DeliveryScreen) -> Unit =
        { value: DeliveryScreen -> pageState = value }


    NavHost(navController = navController, startDestination = DeliveryScreen.Login.name) {

        //Login page
        composable(DeliveryScreen.Login.name) {
            LoginPage(
                onSignUpDeliveryPersonButtonClicked = { navController.navigate(DeliveryScreen.SignUpPersonalDeliveryManData.name) },
                onSingUpClientButtonClicked = { navController.navigate(DeliveryScreen.SignUpPersonalClientData.name) },
                onLoginButtonClicked = { navController.navigate(DeliveryScreen.Home.name) }
            )

        }
        //SingUp Delivery person pages
        composable(DeliveryScreen.SignUpPersonalDeliveryManData.name) {
            SignUpPersonalDeliveryPersonDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.SignUpAccessDeliveryPersonData.name)
            })
        }
        composable(DeliveryScreen.SignUpAccessDeliveryPersonData.name) {
            SignUpAccessDeliveryPersonDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.SignUpAddressDeliveryPersonData.name)
            })
        }
        composable(DeliveryScreen.SignUpAddressDeliveryPersonData.name) {
            SignUpAddressDeliveryPersonDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.SignUpVehicleDeliveryPersonData.name)
            })
        }
        composable(DeliveryScreen.SignUpVehicleDeliveryPersonData.name) {
            SignUpVehicleDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.Home.name)
            })
        }
        composable(DeliveryScreen.SignUpPaymentDeliveryPersonData.name) {
            SignUpPaymentDeliveryPersonDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.Home.name)
            })
        }
        //SingUp Client pages
        composable(DeliveryScreen.SignUpPersonalClientData.name) {
            SignUpPersonalClientDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.SignUpAccessClientData.name)
            })
        }
        composable(DeliveryScreen.SignUpAccessClientData.name) {
            SignUpAccessClientDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.SignUpAddressClientData.name)
            })
        }
        composable(DeliveryScreen.SignUpAddressClientData.name) {
            SignUpAddressClientDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.SignUpDeliveryData.name)
            })
        }
        composable(DeliveryScreen.SignUpDeliveryData.name) {
            SignUpDeliveryDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.SignUpPaymentClientData.name)
            })
        }
        composable(DeliveryScreen.SignUpPaymentClientData.name) {
            SignUpPaymentClientDataPage(onCancelButtonClicked = {
                navController.popBackStack()
            }, onNextButtonClicked = {
                navController.navigate(DeliveryScreen.Home.name)
            })
        }
        //Home
        composable(DeliveryScreen.Home.name) {
            HomePage()
        }

    }
}

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onSignUpDeliveryPersonButtonClicked: () -> Unit = {},
    onSingUpClientButtonClicked: () -> Unit = {},
    onLoginButtonClicked: () -> Unit = {}
) {

    val viewModel: LoginViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val email by rememberSaveable { mutableStateOf("") }
    val password by rememberSaveable { mutableStateOf("") }

    var isClicked by remember { mutableStateOf(false) }
    var visiblePassword by remember { mutableStateOf(false) }

    val messages = mapOf(
        stringResource(R.string.login_carousel_message_1) to stringResource(R.string.login_carousel_message_1_1),
        stringResource(R.string.login_carousel_message_2) to stringResource(R.string.login_carousel_message_2_1),
        stringResource(R.string.login_carousel_message_3) to stringResource(R.string.login_carousel_message_3_1),
        )

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        AppLogo()

        InfiniteCarousel(items = messages)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.login_message))
            Spacer(modifier = Modifier.size(16.dp))
            TextField(
                value = viewModel.email,
                onValueChange = { viewModel.onEmailChange(it) },
                label = { Text(stringResource(R.string.email_label)) },
                modifier = modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.size(16.dp))
            TextField(
                value = viewModel.password,
                onValueChange = { viewModel.onPasswordChange(it) },
                label = { Text(stringResource(R.string.password_label)) },
                visualTransformation = if (visiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = modifier.fillMaxWidth(),
                trailingIcon = {
                    TextButton(onClick = {
                        visiblePassword = !visiblePassword
                    }) {
                        Icon(Icons.Outlined.Visibility, "Visibility")
                    }
                })
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
            Button(onClick = onLoginButtonClicked, modifier = modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.login_button).uppercase(Locale.ROOT))
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(R.string.signup_message))
                TextButton(
                    onClick = { isClicked = true },
                ) {
                    Text(text = stringResource(R.string.signup_button))

                }
            }
            if (isClicked) {
                Dialog(
                    onDismissRequest = { isClicked = false },
                    content = {
                        CardSignUp(
                            onSignUpDeliveryPersonButtonClicked = onSignUpDeliveryPersonButtonClicked,
                            onSignUpClientButtonClicked = onSingUpClientButtonClicked
                        )
                    },
                    properties = DialogProperties(
                        dismissOnBackPress = true, dismissOnClickOutside = true
                    ),
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    AppTheme {
        Surface {
            DeliveryApp()
        }
    }
}
