package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

import com.pmalaquias.deliveryexpress.data.models.enums.DeliveryType

interface IDeliveryDataViewModel {
    var deliveryType: DeliveryType
    var isLoading: Boolean

    fun onDeliveryTypeChange(deliveryType: DeliveryType)
    fun onLoadingChange(isLoading: Boolean)
    fun reset()
}