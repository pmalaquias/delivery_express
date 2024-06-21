package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryType

/**
 * An interface that defines the properties and methods for managing delivery data in a ViewModel.
 *
 * This interface is designed to be implemented by ViewModel classes that need to handle user delivery data, such as delivery type and loading state.
 */
interface IDeliveryDataViewModel {

    /**
     * The user's selected delivery type.
     */
    var deliveryType: DeliveryType

    /**
     * The loading state of the ViewModel.
     */
    var isLoading: Boolean

    /**
     * Updates the value of the "deliveryType" field.
     *
     * @param deliveryType The new value of the "deliveryType" field.
     */
    fun onDeliveryTypeChange(deliveryType: DeliveryType)

    /**
     * Updates the value of the "isLoading" field.
     *
     * @param isLoading The new value of the "isLoading" field.
     */
    fun onLoadingChange(isLoading: Boolean)

    /**
     * Resets the ViewModel to its initial state.
     */
    fun reset()
}