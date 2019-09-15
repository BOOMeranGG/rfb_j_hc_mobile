package com.devian_orange.myapplication.web

import com.devian_orange.myapplication.STANDARD_PATH
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    private var retrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor)
        retrofit = Retrofit.Builder()
            .baseUrl(STANDARD_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }

    companion object {
        private var networkService: NetworkService? = null

        fun getInstance(): NetworkService {
            if (networkService == null) {
                networkService =  NetworkService()
            }
            return networkService!!
        }
    }

    fun getJsonRegApi(): RegistrationApi {
        return retrofit.create(RegistrationApi::class.java)
    }

    fun getJsonOrderApi(): GetOrderApi {
        return retrofit.create(GetOrderApi::class.java)
    }
}