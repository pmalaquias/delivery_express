package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryPersonStatus
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.VehicleColor
import com.pmalaquias.deliveryexpress.presentation.ui.pages.signup.VehicleType
import java.util.Date

data class DeliveryPerson(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phone: Int,
    val address: String,
    val photo: String,
    val currentLocation: String,
    val vehicleType: VehicleType,
    val vehiclePlate: String,
    val vehicleColor: VehicleColor,
    val registerDate: Date,
    val status: DeliveryPersonStatus
)

