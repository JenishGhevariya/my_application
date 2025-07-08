package com.example.myapplication.carts_API
class Cart(
    val id: Int,
    val userId: Int,
    val total: Double,
    val discountedTotal: Double,
    val products: List<Product>
)