package com.example.myapplication.carts_API

import java.io.Serializable

class Product(
    val id: Int,
    val title: String,
    val quantity: Int,
    val price: Double,
    val total: Double,
    val discountPercentage: Double,
    val discountedTotal: Double,
    val thumbnail: String,
):Serializable