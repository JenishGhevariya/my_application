package com.example.myapplication.product_Api
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path;

interface APIInterface {

    @GET("products")
    fun getProducts(): Call<ProductsResponseModel>

    @GET("products/{id}")
    fun getProductById(@Path("id") id: Int): Call<ProductSecondScreen>
}
