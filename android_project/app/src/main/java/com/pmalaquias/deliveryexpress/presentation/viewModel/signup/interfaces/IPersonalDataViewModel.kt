package com.pmalaquias.deliveryexpress.presentation.viewModel.signup.interfaces

interface IPersonalDataViewModel {
    var name: String
    var birthDate: String
    var id: String
    var phone: String
    var photoPath: String

    fun savePersonalData()
    fun onNameChange(name: String)
    fun onBirthDateChange(birthDate: String)
    fun onIdChange(id: String)
    fun onPhoneChange(phone: String)
    fun onPhotoChange(photoPath: String)
    fun isLoading(): Boolean
    fun validatePersonalData(): Boolean
    fun clearError()
}