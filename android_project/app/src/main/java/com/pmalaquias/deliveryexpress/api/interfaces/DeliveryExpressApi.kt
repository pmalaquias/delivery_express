package com.pmalaquias.deliveryexpress.api.interfaces

import com.pmalaquias.deliveryexpress.data.models.Order
import com.pmalaquias.deliveryexpress.data.models.User


interface DeliveryExpressApi {
    suspend fun login(username: String, password: String): User
    suspend fun fetchOrders(): List<Order>
    // Add other API methods here
}
