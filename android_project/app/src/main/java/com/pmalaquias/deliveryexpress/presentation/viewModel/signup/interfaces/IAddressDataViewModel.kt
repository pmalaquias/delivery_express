package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

interface IAddressDataViewModel {
    var street: String
    var number: Int
    var zipCode: Int
    var complement: String
    var neighborhood: String
    var city: String
    var state: String
    var maximumDistanceMap: Double

    fun onStreetChange(street: String)
    fun onNumberChange(number: Int)
    fun onZipCodeChange(zipCode: Int)
    fun onComplementChange(complement: String)
    fun onNeighborhoodChange(neighborhood: String)
    fun onCityChange(city: String)
    fun onStateChange(state: String)
    fun onMaximumDistanceMapChange(maximumDistanceMap: Double)
    fun isLoading(): Boolean
    fun validateAddressData(): Boolean
    fun clearError()
    fun saveAddressData()
}