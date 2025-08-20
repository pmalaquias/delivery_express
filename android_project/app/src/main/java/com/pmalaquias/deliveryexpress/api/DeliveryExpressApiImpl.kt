package com.pmalaquias.deliveryexpress.api

import com.pmalaquias.deliveryexpress.api.interfaces.DeliveryExpressApi
import com.pmalaquias.deliveryexpress.api.interfaces.DeliveryExpressApiService
import com.pmalaquias.deliveryexpress.data.models.Order
import com.pmalaquias.deliveryexpress.data.models.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class DeliveryExpressApiImpl @Inject constructor (private val baseUrl: String) :
    DeliveryExpressApi {

    private val retroFilClient: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: DeliveryExpressApiService = retroFilClient.create(
        DeliveryExpressApiService::class.java)

    override suspend fun login(username: String, password: String): User {
        val loginRequest = LoginRequest(username, password)
        val response = apiService.login(loginRequest)
        // Check response for errors and handle appropriately
        return response.body() ?: throw Exception("Login failed")
    }

    override suspend fun fetchOrders(): List<Order> {
        val response = apiService.fetchOrders()
        // Check response for errors and handle appropriately
        return response ?: throw Exception("Failed to fetch orders")
    }
}
