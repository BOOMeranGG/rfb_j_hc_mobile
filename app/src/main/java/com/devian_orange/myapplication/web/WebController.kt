package com.devian_orange.myapplication.web

import android.util.Log
import com.devian_orange.myapplication.model.dto.OrderDto
import com.devian_orange.myapplication.model.dto.RegistrationDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebController {

    interface OrdersController {
        fun onCompleteWaitingOrders(orders: List<OrderDto>)
    }

    fun getAllOrders(listener: OrdersController) {
        NetworkService.getInstance()
            .getJsonOrderApi()
            .getAllOrders()
            .enqueue(object : Callback<List<OrderDto>> {

                override fun onResponse(call: Call<List<OrderDto>>, response: Response<List<OrderDto>>) {
                    val body = response.body()
                    if (body != null) {
                        listener.onCompleteWaitingOrders(body)
                    }
                    Log.e("TAG322", "getAllOrders: all right")
                }

                override fun onFailure(call: Call<List<OrderDto>>, t: Throwable) {
                    Log.e("TAG322", "getAllOrders onFailure ${t.message} + $t + ${t.printStackTrace()}")
                }
            })
    }

    fun registerInWeb(registrationDto: RegistrationDto) {
        NetworkService.getInstance()
            .getJsonRegApi()
            .register(registrationDto)
            .enqueue(object : Callback<Unit> {

                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    val body = response.body()
                    if (body != null) {
                        Log.e("TAG322", "registerInWeb: all right")
                    } else {
                        Log.e("TAG322", "registerInWeb: smth went wrong, body is null")
                    }
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.e("TAG322", "registerInWeb onFailure ${t.message} + $t + ${t.printStackTrace()}")
                    println(4)
                }
            })
    }

}