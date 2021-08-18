package com.example.student_resigration.UserViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.student_resigration.Models.RegistrationRequest
import com.example.student_resigration.Models.RegistrationResponse
import com.example.student_resigration.UerRepository.UerRepository

class UserViewModel {

    var UerRepo = UerRepository()
    var registrationResponseData= MutableLiveData<RegistrationResponse>()
    var regiErrorLiveData= MutableLiveData<String>()

    fun registerStudent(registration: RegistrationRequest){
        viewModelScope.launch {
            var response = UerRepo.UserRepository(RegistrationRequest)

            if (response.isSuccessful) {
                registrationResponseData.postValue(response.body())
            } else {
                regiErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}