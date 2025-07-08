package com.example.myapplication.carts_API

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("carts")
    fun getCarts(): Call<CartResponse>

}