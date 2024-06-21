package com.pmalaquias.deliveryexpress.domain.entities

/**
 * Data class representing an Order entity in the domain layer.
 *
 * @property idOrder The unique identifier of the order.
 * @property idClient The client who made the order. It is an instance of the Client data class.
 * @property idCommerce The commerce where the order was made. It is an instance of the Commerce data class.
 * @property products The list of products in the order. Each product is an instance of the Product data class.
 * @property total The total cost of the order.
 */
data class Order(
    val idOrder: Int,
    val idClient: Client,
    val idCommerce: Commerce,
    val products: List<Product>,
    val total: Double
)
