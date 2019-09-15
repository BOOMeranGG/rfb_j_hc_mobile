package com.devian_orange.myapplication.model.dto

import com.google.gson.annotations.SerializedName

class OrderDto(

    @SerializedName("jobId")
    val jobId: Int,

    @SerializedName("login")
    val login: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("price")
    val price: Int
)