package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryPersonStatus
import com.pmalaquias.deliveryexpress.data.models.enums.VehicleColor
import com.pmalaquias.deliveryexpress.data.models.enums.VehicleType
import java.util.Date

/**
 * Data class representing a DeliveryPerson entity.
 *
 * @property id Unique identifier for the delivery person.
 * @property firstName First name of the delivery person.
 * @property lastName Last name of the delivery person.
 * @property email Email address of the delivery person.
 * @property password Password for the delivery person. In a real-world application, this would be hashed and salted.
 * @property phone Phone number of the delivery person.
 * @property address Address of the delivery person.
 * @property photo URL or path to the photo of the delivery person.
 * @property currentLocation Current location of the delivery person.
 * @property vehicleType Type of vehicle the delivery person uses for delivery.
 * @property vehiclePlate Plate number of the vehicle.
 * @property vehicleColor Color of the vehicle.
 * @property registerDate Date when the delivery person registered.
 * @property status Current status of the delivery person.
 */
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

