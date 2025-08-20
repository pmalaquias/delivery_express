package com.pmalaquias.deliveryexpress.api.interfaces

import com.pmalaquias.deliveryexpress.api.LoginRequest
import com.pmalaquias.deliveryexpress.data.models.Order
import com.pmalaquias.deliveryexpress.data.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DeliveryExpressApiService {
    @POST("/login")
    suspend fun login(@Body user: LoginRequest): User

    @GET("/orders")
    suspend fun fetchOrders(): List<Order>
}
