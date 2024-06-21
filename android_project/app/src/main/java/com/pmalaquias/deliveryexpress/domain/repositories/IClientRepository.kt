package com.pmalaquias.deliveryexpress.domain.repositories

import com.pmalaquias.deliveryexpress.domain.entities.Client

/**
 * Interface for the Client Repository.
 *
 * This interface defines the operations that can be performed on a Client in the repository.
 *
 * @function getClientById Fetches a client by their unique identifier.
 * @param id The unique identifier of the client.
 * @return The client if found, null otherwise.
 *
 * @function saveClient Saves a new client to the repository.
 * @param client The client to be saved.
 *
 * @function updateClient Updates an existing client in the repository.
 * @param client The client with updated information.
 *
 * @function deleteClient Deletes a client from the repository.
 * @param client The client to be deleted.
 *
 * @function getAllClients Fetches all clients from the repository.
 * @return A list of all clients.
 */
interface IClientRepository {
    fun getClientById(id: Long): Client?
    fun saveClient(client: Client)
    fun updateClient(client: Client)
    fun deleteClient(client: Client)
    fun getAllClients(): List<Client>
}