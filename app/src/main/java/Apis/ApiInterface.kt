package Apis

import com.example.student_resigration.Models.RegistrationRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("posts")
    fun getPosts(): Call<List<POST>>

    fun registerStudent(@Body registrationRequest: RegistrationRequest): Call<RegistrationRequest> //remove call/Response

//    @POST("/students/register")
//    fun Students(@Body loginRequest: LogInResponse): Call<LogInResponse>
}