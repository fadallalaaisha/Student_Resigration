package com.example.student_resigration.UerRepository

import Apis.ApiCliets
import Apis.ApiInterface
import androidx.lifecycle.MutableLiveData
import com.example.student_resigration.Models.RegistrationRequest
import com.example.student_resigration.Models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UerRepository {
    var apiInterface=ApiCliets.buildApiClient(ApiInterface::class.java)
    suspend fun requesterUser(registrationRequest:RegistrationRequest):Response<RegistrationResponse> =
    withContext(Dispatchers.IO){
        var response=requesterUser(registrationRequest)
        return@withContext response
    }
}