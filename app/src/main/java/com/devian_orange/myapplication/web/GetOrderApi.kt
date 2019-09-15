package com.devian_orange.myapplication.web

import com.devian_orange.myapplication.model.dto.OrderDto
import retrofit2.Call
import retrofit2.http.GET

interface GetOrderApi {

    @GET("/job/findall")
    fun getAllOrders(): Call<List<OrderDto>>
}