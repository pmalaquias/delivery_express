package com.pmalaquias.deliveryexpress.presentation.ui.pages

import SignUpAddressDeliveryPersonDataPage
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.HomeDeliveryPersonPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.home.HomePage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.login.LoginPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpAccessClientDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpAccessDeliveryPersonDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpAddressClientDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpDeliveryDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpPaymentClientDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpPaymentDeliveryPersonDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpPersonalClientDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpPersonalDeliveryPersonDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.SignUpVehicleDataPage
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpAccessDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpAddressDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpDeliveryDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpPaymentDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignUpVehicleDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignupClientPersonalDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignupDeliveryPersonPersonalDataViewModel

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
    Home,
    HomeDeliveryPersonPage
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

    val signupDeliveryPersonPersonalDataViewModel: SignupDeliveryPersonPersonalDataViewModel = viewModel()
    val signUpDeliveryPersonAccessDataDataViewModel: SignUpAccessDataViewModel = viewModel()
    val signUpVehicleDataViewModel: SignUpVehicleDataViewModel = viewModel()

    val signupClientPersonalDataViewModel: SignupClientPersonalDataViewModel = viewModel()
    val signUpPaymentDataViewModel: SignUpPaymentDataViewModel = viewModel()
    val signUpClientAccessDataDataViewModel: SignUpAccessDataViewModel = viewModel()
    val signUpAddressDataViewModel: SignUpAddressDataViewModel = viewModel()
    val signUpDeliveryDataViewModel: SignUpDeliveryDataViewModel = viewModel()

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
            SignUpPersonalDeliveryPersonDataPage(
                onCancelButtonClicked = {navController.popBackStack()},
                onNextButtonClicked = {navController.navigate(DeliveryScreen.SignUpAccessDeliveryPersonData.name)},
                viewModel = signupDeliveryPersonPersonalDataViewModel

            )
        }
        composable(DeliveryScreen.SignUpAccessDeliveryPersonData.name) {
            SignUpAccessDeliveryPersonDataPage(
                onCancelButtonClicked = {navController.popBackStack()},
                onNextButtonClicked = {navController.navigate(DeliveryScreen.SignUpAddressDeliveryPersonData.name)},
                viewModel = signUpDeliveryPersonAccessDataDataViewModel
            )
        }
        composable(DeliveryScreen.SignUpAddressDeliveryPersonData.name) {
            SignUpAddressDeliveryPersonDataPage(
                onCancelButtonClicked = {navController.popBackStack()},
                onNextButtonClicked = {navController.navigate(DeliveryScreen.SignUpVehicleDeliveryPersonData.name)},
                viewModel = signUpAddressDataViewModel
            )
        }
        composable(DeliveryScreen.SignUpVehicleDeliveryPersonData.name) {
            SignUpVehicleDataPage(
                onCancelButtonClicked = {navController.popBackStack()},
                onNextButtonClicked = {navController.navigate(DeliveryScreen.Home.name)},
                viewModel = signUpVehicleDataViewModel
            )
        }
        composable(DeliveryScreen.SignUpPaymentDeliveryPersonData.name) {
            SignUpPaymentDeliveryPersonDataPage(
                onCancelButtonClicked = {navController.popBackStack()},
                onNextButtonClicked = {navController.navigate(DeliveryScreen.HomeDeliveryPersonPage.name)},
                viewModel = signUpPaymentDataViewModel,
            )
        }
        //SingUp Client pages
        composable(DeliveryScreen.SignUpPersonalClientData.name) {
            SignUpPersonalClientDataPage(
                onCancelButtonClicked = { navController.popBackStack() },
                onNextButtonClicked = { navController.navigate(DeliveryScreen.SignUpAccessClientData.name) },
                viewModel = signupClientPersonalDataViewModel
            )
        }
        composable(DeliveryScreen.SignUpAccessClientData.name) {
            SignUpAccessClientDataPage(
                onCancelButtonClicked = { navController.popBackStack() },
                onNextButtonClicked = { navController.navigate(DeliveryScreen.SignUpAddressClientData.name) },
                viewModel = signUpClientAccessDataDataViewModel
            )
        }
        composable(DeliveryScreen.SignUpAddressClientData.name) {
            SignUpAddressClientDataPage(
                onCancelButtonClicked = { navController.popBackStack() },
                onNextButtonClicked = { navController.navigate(DeliveryScreen.SignUpDeliveryData.name) },
                viewModel = signUpAddressDataViewModel
            )
        }
        composable(DeliveryScreen.SignUpDeliveryData.name) {
            SignUpDeliveryDataPage(
                onCancelButtonClicked = { navController.popBackStack() },
                onNextButtonClicked = { navController.navigate(DeliveryScreen.SignUpPaymentClientData.name) },
                viewModel = signUpDeliveryDataViewModel
            )
        }
        composable(DeliveryScreen.SignUpPaymentClientData.name) {
            SignUpPaymentClientDataPage(
                onCancelButtonClicked = { navController.popBackStack() },
                onNextButtonClicked = { navController.navigate(DeliveryScreen.Home.name) },
                viewModel = signUpPaymentDataViewModel,
                personalDataViewModel = signupClientPersonalDataViewModel
            )
        }
        //Home
        composable(DeliveryScreen.Home.name) {
            HomePage()
        }
        composable(DeliveryScreen.HomeDeliveryPersonPage.name) {
            HomeDeliveryPersonPage()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DeliveryAppPreview() {
    AppTheme {
        Surface {
            DeliveryApp()
        }
    }
}