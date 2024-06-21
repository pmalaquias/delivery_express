package com.pmalaquias.deliveryexpress.domain.repositories

import com.pmalaquias.deliveryexpress.domain.entities.User

/**
 * Interface for the User Repository.
 *
 * This interface defines the operations that can be performed on a User in the repository.
 *
 * @function getUserByEmail Fetches a user by their email.
 * @param email The email of the user.
 * @return The user if found, null otherwise.
 *
 * @function getUserById Fetches a user by their unique identifier.
 * @param id The unique identifier of the user.
 * @return The user if found, null otherwise.
 *
 * @function saveUser Saves a new user to the repository.
 * @param user The user to be saved.
 *
 * @function updateUser Updates an existing user in the repository.
 * @param user The user with updated information.
 *
 * @function deleteUser Deletes a user from the repository.
 * @param user The user to be deleted.
 *
 * @function getAllUsers Fetches all users from the repository.
 * @return A list of all users.
 */
interface IUserRepository {
    fun getUserByEmail(email: String): User?
    fun getUserById(id: Long): User?
    fun saveUser(user: User)
    fun updateUser(user: User)
    fun deleteUser(user: User)
    fun getAllUsers(): List<User>
}