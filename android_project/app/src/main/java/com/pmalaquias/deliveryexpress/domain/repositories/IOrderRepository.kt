package com.pmalaquias.deliveryexpress.domain.repositories

import com.pmalaquias.deliveryexpress.domain.entities.Order

/**
 * Interface for the Order Repository.
 *
 * This interface defines the operations that can be performed on an Order in the repository.
 *
 * @function getOrderById Fetches an order by their unique identifier.
 * @param id The unique identifier of the order.
 * @return The order if found, null otherwise.
 *
 * @function saveOrder Saves a new order to the repository.
 * @param order The order to be saved.
 *
 * @function updateOrder Updates an existing order in the repository.
 * @param order The order with updated information.
 *
 * @function deleteOrder Deletes an order from the repository.
 * @param order The order to be deleted.
 *
 * @function getAllOrders Fetches all orders from the repository.
 * @return A list of all orders.
 */
interface IOrderRepository {
    fun getOrderById(id: Long): Order?
    fun saveOrder(order: Order)
    fun updateOrder(order: Order)
    fun deleteOrder(order: Order)
    fun getAllOrders(): List<Order>
}