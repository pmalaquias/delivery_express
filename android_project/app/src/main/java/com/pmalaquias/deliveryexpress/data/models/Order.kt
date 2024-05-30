package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.OrderStatus
import com.pmalaquias.deliveryexpress.data.models.enums.PaymentMethod

data class Order(
    val idOrder: Int,
    val idUser: Users,
    val idCommerce: Commerce,
    val idDelivery: DeliveryPerson,
    val idTracker: Tracker,
    val addressTarget: String,
    val orderItems: List<OrderItem>,
    val paymentMethod: PaymentMethod,
    val totalAmount: Double,
    val status: OrderStatus
)