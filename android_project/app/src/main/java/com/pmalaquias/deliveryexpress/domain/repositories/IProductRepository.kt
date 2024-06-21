package com.pmalaquias.deliveryexpress.domain.repositories

import com.pmalaquias.deliveryexpress.domain.entities.Product

/**
 * Interface for the Product Repository.
 *
 * This interface defines the operations that can be performed on a Product in the repository.
 *
 * @function getProductById Fetches a product by their unique identifier.
 * @param id The unique identifier of the product.
 * @return The product if found, null otherwise.
 *
 * @function saveProduct Saves a new product to the repository.
 * @param product The product to be saved.
 *
 * @function updateProduct Updates an existing product in the repository.
 * @param product The product with updated information.
 *
 * @function deleteProduct Deletes a product from the repository.
 * @param product The product to be deleted.
 *
 * @function getAllProducts Fetches all products from the repository.
 * @return A list of all products.
 */
interface IProductRepository {
    fun getProductById(id: Long): Product?
    fun saveProduct(product: Product)
    fun updateProduct(product: Product)
    fun deleteProduct(product: Product)
    fun getAllProducts(): List<Product>
}