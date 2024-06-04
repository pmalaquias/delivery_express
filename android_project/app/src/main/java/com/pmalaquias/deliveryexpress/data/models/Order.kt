package com.pmalaquias.deliveryexpress.data.models

import com.pmalaquias.deliveryexpress.data.models.enums.OrderStatus
import com.pmalaquias.deliveryexpress.data.models.enums.PaymentMethod

/**
 * Data class representing an Order entity.
 *
 * @property idOrder Unique identifier for the order.
 * @property idUser Reference to the User entity who placed the order.
 * @property idCommerce Reference to the Commerce entity from where the order was placed.
 * @property idDelivery Reference to the DeliveryPerson entity who is responsible for delivering the order.
 * @property idTracker Reference to the Tracker entity which tracks the status of the order.
 * @property addressTarget The address where the order needs to be delivered.
 * @property orderItems List of OrderItem entities associated with this order.
 * @property paymentMethod The method of payment used for this order.
 * @property totalAmount The total amount of the order.
 * @property status The current status of the order.
 */
data class Order(
    val idOrder: Int,
    val idUser: User,
    val idCommerce: Commerce,
    val idDelivery: DeliveryPerson,
    val idTracker: Tracker,
    val addressTarget: String,
    val orderItems: List<OrderItem>,
    val paymentMethod: PaymentMethod,
    val totalAmount: Double,
    val status: OrderStatus
)