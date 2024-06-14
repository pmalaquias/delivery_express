package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

interface IVehicleDataViewModel {

    var vehicleType : String
    var vehicleModel : String
    var vehiclePlate : String
    var vehicleColor : String
    var isLoading : Boolean

    fun onVehicleTypeChange(vehicleType: String)
    fun onVehicleModelChange(vehicleModel: String)
    fun onVehiclePlateChange(vehiclePlate: String)
    fun onVehicleColorChange(vehicleColor: String)
    fun onVehicleSubmit()
    fun validateVehicleData(): Boolean
    fun clearError()
    fun showError(message: String)
    fun isLoading(): Boolean
    fun resetVehicleData()

}