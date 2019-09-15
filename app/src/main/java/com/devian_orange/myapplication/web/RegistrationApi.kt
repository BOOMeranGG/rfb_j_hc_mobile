package com.devian_orange.myapplication.web

import com.devian_orange.myapplication.model.dto.RegistrationDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationApi {

    @POST("/registration")
    fun register(@Body registrationDto: RegistrationDto): Call<Unit>
}