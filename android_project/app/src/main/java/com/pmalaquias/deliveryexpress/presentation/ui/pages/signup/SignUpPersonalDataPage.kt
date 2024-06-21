package com.pmalaquias.deliveryexpress.presentation.ui.pages.signup

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.star
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.pmalaquias.deliveryexpress.R
import com.pmalaquias.deliveryexpress.presentation.ui.componets.RoundedPolygonShape
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.AppBarClient
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.AppBarDeliveryPerson
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.components.ChoicePhotoBottomSheet
import com.pmalaquias.deliveryexpress.presentation.ui.theme.AppTheme
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignupClientPersonalDataViewModel
import com.pmalaquias.deliveryexpress.presentation.viewModel.signup.SignupDeliveryPersonPersonalDataViewModel
import kotlinx.coroutines.delay
import java.io.File

/**
 * Composable function that displays the personal data page for a delivery person during sign up.
 *
 * This function displays a form where the delivery person can enter their personal data, including their name, birth date, ID, phone number, and photo.
 * The photo can be taken with the camera or selected from the gallery.
 * The form also includes a "Back" button and a "Continue" button.
 * The "Back" button invokes the `onCancelButtonClicked` function when clicked.
 * The "Continue" button invokes the `onNextButtonClicked` function when clicked.
 *
 * @param onCancelButtonClicked Function to be invoked when the "Back" button is clicked. Default is an empty function.
 * @param onNextButtonClicked Function to be invoked when the "Continue" button is clicked. Default is an empty function.
 * @param modifier The modifier to be applied to the layout. Default is an empty Modifier.
 */
@Composable
fun SignUpPersonalDeliveryPersonDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    // ViewModel for the SignupDeliveryPersonPersonalData screen.
    val viewModel: SignupDeliveryPersonPersonalDataViewModel = viewModel()

    // Local context.
    val context = LocalContext.current

    // Mutable state for the URI of the photo.
    var uri: MutableState<Uri?> = remember { mutableStateOf(null) } //target url to preview

    // Directory where the photo is stored.
    var directory: File? = File(context.cacheDir, "images") // stored directory

    // Function to set the URI of the photo.
    var onSetUri: (Uri) -> Unit = { uri.value = it } // selected / taken uri

    // Function to upload the photo.
    var upload: (Uri) -> Unit = {}

    // Temporary URI for the photo.
    val tempUri = remember { mutableStateOf<Uri?>(null) }

    // Authority for the file provider.
    val authority = stringResource(id = R.string.fileprovider)

    // Function to get a temporary URI for the photo.
    fun getTempUri(): Uri? {
        directory?.let {
            it.mkdirs()
            val file =
                File.createTempFile("image_" + System.currentTimeMillis().toString(), ".jpg", it)

            return FileProvider.getUriForFile(context, authority, file)
        }
        return null
    }

    // Launcher for picking a photo from the gallery.
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            it?.let {
                onSetUri.invoke(it)
            }
        })

    // Launcher for taking a photo with the camera.
    val takePhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { _ ->
            tempUri.value?.let { onSetUri.invoke(it) }
        })

    // Launcher for requesting the camera permission.
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted, proceed to step 2
            val tmpUri = getTempUri()
            tempUri.value = tmpUri
            tempUri.value?.let {
                takePhotoLauncher.launch(it)
            }

        } else {
            // Permission is denied, handle it accordingly
        }
    }

    // Mutable state for whether the bottom sheet is shown.
    var showBottomSheet by remember { mutableStateOf(false) }

    // Show the bottom sheet if `showBottomSheet` is true.
    if (showBottomSheet) {
        ChoicePhotoBottomSheet(
            onDismiss = { showBottomSheet = false },
            onTakePhotoClick = {
                showBottomSheet = false

                val permission = Manifest.permission.CAMERA
                if (ContextCompat.checkSelfPermission(
                        context, permission
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    // Permission is already granted, proceed to step 2
                    val tmpUri = getTempUri()
                    tempUri.value = tmpUri
                    tempUri.value?.let {
                        takePhotoLauncher.launch(it)
                    }

                } else {
                    // Permission is not granted, request it
                    cameraPermissionLauncher.launch(permission)
                }
            },
            onPhotoGalleryClick = {
                showBottomSheet = false
                imagePicker.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            },
        )
    }

    // Shape for the photo.
    val hexagon = remember {
        RoundedPolygon.star(
            8, rounding = CornerRounding(0.2f)
        )
    }

    // Clip for the photo.
    val clip = remember(hexagon) { RoundedPolygonShape(polygon = hexagon) }


    // Observer for the URI of the photo.
    val uriObserver = remember { mutableStateOf(uri.value) }

    // Update the phone number in the ViewModel when the URI changes.
    LaunchedEffect(uri.value) {
        viewModel.onPhotoChange(uri.value.toString())
        uriObserver.value = uri.value

        // Add a delay of 3 seconds before starting the rotation animation
        delay(1000L)
    }

    // Create an animated state that toggles between 0f and 360f
    val rotation by animateFloatAsState(
        targetValue = if (uriObserver.value != null) 360f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    // Scaffold for the layout.
    Scaffold(Modifier, topBar = { AppBarDeliveryPerson() }) { innerPadding ->

        // Column for the layout.
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Column for the photo and the title.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Title.
                Text(
                    text = stringResource(id = R.string.personal_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))

                // Photo.
                if (uriObserver.value != null) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .graphicsLayer(rotationZ = rotation) // Apply the rotation to the photo frame
                            .clickable { showBottomSheet = true }
                    ) {
                        AsyncImage(
                            model = uriObserver.value,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(250.dp)
                                .clip(clip)
                                .border(1.dp, Color.Transparent, CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                    }
                } else {
                    Box(modifier = modifier.size(200.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.unknown_person),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Transparent, CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                        IconButton(
                            onClick = { showBottomSheet = true },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(4.dp)
                        ) {
                            Icon(
                                Icons.Outlined.Add,
                                contentDescription = stringResource(id = R.string.add_photo),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color.White, CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                            )
                        }
                    }
                }
            }

            // Column for the form.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().padding(16.dp)

            ) {
                // Name field.
                TextField(
                    value = viewModel.name,
                    onValueChange = { viewModel.onNameChange(it) },
                    label = { Text(stringResource(id = R.string.full_name)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))

                // Birth date field.
                TextField(
                    value = viewModel.birthDate,
                    onValueChange = {
                        val newDate = it.replace("[^0-9]".toRegex(), "")
                        viewModel.onBirthDateChange(newDate)

                        if (newDate.length == 8) {
                            //formattedDate.value = sdf.format(Date(newText.toLong()))
                        }
                    },

                    label = { Text(stringResource(id = R.string.birth_date)) },
                    modifier = modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.padding(8.dp))

                // ID field.
                TextField(
                    value = viewModel.id,
                    onValueChange = { viewModel.onIdChange(it) },
                    label = { Text(stringResource(id = R.string.cpf)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))

                // Phone number field.
                TextField(
                    value = viewModel.phone,
                    onValueChange = { viewModel.onPhoneChange(it) },
                    label = { Text(stringResource(id = R.string.phone_number)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))


            }

            // Row for the "Back" and "Continue" buttons.
            Row(
                modifier = modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // "Back" button.
                TextButton(
                    onClick = onCancelButtonClicked
                ) {
                    Text(text = stringResource(id = R.string.back_button))
                }

                // "Continue" button.
                Button(onClick = onNextButtonClicked) {
                    Text(text = stringResource(id = R.string.continue_button))

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPagePreview() {
    AppTheme {
        SignUpPersonalDeliveryPersonDataPage()
    }
}

/**
 * Composable function that displays the personal data page for a client during sign up.
 *
 * This function displays a form where the client can enter their personal data, including their name, commercial name, birth date, ID, phone number, and photo.
 * The photo can be taken with the camera or selected from the gallery.
 * The form also includes a "Back" button and a "Continue" button.
 * The "Back" button invokes the `onCancelButtonClicked` function when clicked.
 * The "Continue" button invokes the `onNextButtonClicked` function when clicked.
 *
 * @param onCancelButtonClicked Function to be invoked when the "Back" button is clicked. Default is an empty function.
 * @param onNextButtonClicked Function to be invoked when the "Continue" button is clicked. Default is an empty function.
 * @param modifier The modifier to be applied to the layout. Default is an empty Modifier.
 */
@Composable
fun SignUpPersonalClientDataPage(
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: SignupClientPersonalDataViewModel,
) {
    // ViewModel for the SignupClientPersonalData screen.
    //val viewModel: SignupClientPersonalDataViewModel = viewModel()

    // Local context.
    val context = LocalContext.current

    // Mutable state for the URI of the photo.
    var uri: MutableState<Uri?> = remember { mutableStateOf(null) } //target url to preview

    // Directory where the photo is stored.
    var directory: File? = File(context.cacheDir, "images") // stored directory

    // Function to set the URI of the photo.
    var onSetUri: (Uri) -> Unit = { uri.value = it } // selected / taken uri

    // Function to upload the photo.
    var upload: (Uri) -> Unit = {}

    // Temporary URI for the photo.
    val tempUri = remember { mutableStateOf<Uri?>(null) }

    // Authority for the file provider.
    val authority = stringResource(id = R.string.fileprovider)

    // Function to get a temporary URI for the photo.
    fun getTempUri(): Uri? {
        directory?.let {
            it.mkdirs()
            val file = File.createTempFile(
                "image_" + System.currentTimeMillis().toString(), ".jpg", it
            )

            println("file: $file")

            return FileProvider.getUriForFile(
                context, authority, file
            )
        }
        return null
    }

    // Launcher for picking a photo from the gallery.
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            it?.let {
                onSetUri.invoke(it)
            }
        })

    // Launcher for taking a photo with the camera.
    val takePhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { _ ->
            tempUri.value?.let {
                onSetUri.invoke(it)
            }
        })

    // Launcher for requesting the camera permission.
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted, proceed to step 2
            val tmpUri = getTempUri()
            tempUri.value = tmpUri
            tempUri.value?.let {
                takePhotoLauncher.launch(it)
            }

        } else {
            // Permission is denied, handle it accordingly
        }
    }

    // Mutable state for whether the bottom sheet is shown.
    var showBottomSheet by remember { mutableStateOf(false) }

    // Show the bottom sheet if `showBottomSheet` is true.
    if (showBottomSheet) {
        ChoicePhotoBottomSheet(
            onDismiss = {
                showBottomSheet = false
            },
            onTakePhotoClick = {
                showBottomSheet = false

                val permission = Manifest.permission.CAMERA
                if (ContextCompat.checkSelfPermission(
                        context, permission
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    // Permission is already granted, proceed to step 2
                    val tmpUri = getTempUri()
                    tempUri.value = tmpUri
                    tempUri.value?.let {
                        takePhotoLauncher.launch(it)
                    }

                } else {
                    // Permission is not granted, request it
                    cameraPermissionLauncher.launch(permission)
                }
            },
            onPhotoGalleryClick = {
                showBottomSheet = false
                imagePicker.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            },
        )
    }

    // Shape for the photo.
    val hexagon = remember {
        RoundedPolygon.star(
            8, rounding = CornerRounding(0.2f)
        )
    }

    // Clip for the photo.
    val clip = remember(hexagon) {
        RoundedPolygonShape(polygon = hexagon)
    }

    // Observer for the URI of the photo.
    val uriObserver = remember { mutableStateOf(uri.value) }

    // Update the phone number in the ViewModel when the URI changes.
    LaunchedEffect(uri.value) {
        viewModel.onPhotoChange(uri.value.toString())
        uriObserver.value = uri.value

        // Add a delay of 3 seconds before starting the rotation animation
        delay(1000L)
    }

    // Create an animated state that toggles between 0f and 360f
    val rotation by animateFloatAsState(
        targetValue = if (uriObserver.value != null) 360f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )


    // Scaffold for the layout.
    Scaffold(Modifier.padding(top = 16.dp), topBar = { AppBarClient() }) { innerPadding ->

        // Column for the layout.
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Column for the photo and the title.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.personal_data),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(16.dp))

                // Display the photo if it exists, otherwise display a placeholder.
                if (uriObserver.value != null) {
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .graphicsLayer(rotationZ = rotation) // Apply the rotation to the photo frame
                            .clickable { showBottomSheet = true }) {
                        AsyncImage(
                            model = uriObserver.value,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(250.dp)
                                .clip(clip)
                                .border(1.dp, Color.Transparent, CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                    }
                } else {
                    Box(modifier = modifier.size(200.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.unknown_person),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Transparent, CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                        )
                        IconButton(
                            onClick = { showBottomSheet = true },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(4.dp)
                        ) {
                            Icon(
                                Icons.Outlined.Add,
                                contentDescription = stringResource(id = R.string.add_photo),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color.White, CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                            )
                        }
                    }
                }
                //here
            }

            // Column for the form.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                TextField(
                    value = viewModel.name,
                    onValueChange = { viewModel.onNameChange(it) },
                    label = { Text(stringResource(id = R.string.full_name)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.commercialName,
                    onValueChange = { viewModel.onCommercialNameChange(it) },
                    label = { Text(stringResource(id = R.string.commercialName)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.birthDate,
                    onValueChange = {
                        val newText = it.replace("[^0-9]".toRegex(), "")
                        viewModel.onBirthDateChange(newText)

                        if (newText.length == 8) {
                            //formattedDate.value = sdf.format(Date(newText.toLong()))
                        }


                    },

                    label = { Text(stringResource(id = R.string.birth_date)) },
                    modifier = modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.id,
                    onValueChange = { viewModel.onIdChange(it) },
                    label = { Text(stringResource(id = R.string.cpf)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(
                    value = viewModel.phone,
                    onValueChange = { viewModel.onPhoneChange(it) },
                    label = { Text(stringResource(id = R.string.phone_number)) },
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.size(16.dp))


            }
            // Row for the "Back" and "Continue" buttons.
            Row(
                modifier = modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = onCancelButtonClicked
                ) {
                    Text(text = stringResource(id = R.string.back_button))
                }
                Button(onClick = onNextButtonClicked) {
                    Text(text = stringResource(id = R.string.continue_button))

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPersonalClientDataPagePreview() {
    AppTheme {
        SignUpPersonalClientDataPage(viewModel = SignupClientPersonalDataViewModel())
    }
}
