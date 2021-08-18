package com.example.student_resigration

import Apis.ApiCliets
import Apis.ApiInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.student_resigration.Models.LonInRequest
import com.example.student_resigration.Models.RegistrationRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:AppCompatActivity
    lateinit var etName:TextView
    lateinit var etEmail:TextView
    lateinit var spNationality:Spinner
    lateinit var etPhoneNumber:TextView
    lateinit var btnNext:Button
    lateinit var etDOB:TextView
    lateinit var btnPW:TextView
    lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list()
        onClick()
    }
    fun list(){
        etEmail=findViewById(R.id.etEmail)
        etName=findViewById(R.id.etName)
        etPhoneNumber=findViewById(R.id.etPhoneNumber)
        btnNext=findViewById(R.id.btnNext)
        spNationality=findViewById(R.id.spNationality)
        etDOB=findViewById(R.id.etDOB)
        btnPW=findViewById(R.id.btnPW)
        progressBar=findViewById(R.id.progressBar)

        var nationality= arrayOf("Kenya","Sudan","South Sudan","Uganda","Somali","Rwanda")
        var nationalityAdapter=ArrayAdapter(baseContext,android.R.layout.simple_dropdown_item_1line,nationality)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

    }
    fun onClick(){
        btnNext.setOnClickListener {
            var name=etName.text.toString()
            var dob=etDOB.text.toString()
            var nationality=spNationality.selectedItem.toString()
            var phoneNumber=etPhoneNumber.text.toString()
            var email=etEmail.text.toString()
            var password=btnPW.text.toString()
            var progressBar=progressBar.progress

        if (name.isEmpty()||dob.isEmpty()||nationality.isEmpty()||phoneNumber.isEmpty()||email.isEmpty()||password.isEmpty()){
            etName.setError("please enter your name")
            etDOB.setError("please enter your birth day")
            etPhoneNumber.setError("please enter your phone number")
            Toast.makeText(baseContext,"That are your details",Toast.LENGTH_LONG).show()

        }
            var intent=Intent(baseContext,LonInRequest::class.java)
            startActivity(intent)

            var intent2=Intent(baseContext,CourseAdapter::class.java)
            startActivity(intent2)

            var regRequest= RegistrationRequest(
                name=name,phoneNumber=phoneNumber,email=email,DOB = dob,nationality=nationality,password=password
            )

            var retrofit=ApiCliets.buildApiClient(ApiInterface::class.java)
            var request=retrofit.registerStudent(regRequest)
            request.enqueue(object :Callback<RegistrationRequest> {
                override fun onResponse(
                    call: Call<RegistrationRequest>,
                    response: Response<RegistrationRequest>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext,"Your registration is successful",Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(baseContext,response.errorBody()?.toString(),Toast.LENGTH_LONG).show()
                    }                }

                override fun onFailure(call: Call<RegistrationRequest>, t: Throwable) {
                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                }
                //progressBar.visibility= View.GONE

//                    btnNext.setOnClickListener {
//                    var intent=Intent(baseContext,LoginActivity::class.java)
//                        startActivity(intent)
            })}}
}

