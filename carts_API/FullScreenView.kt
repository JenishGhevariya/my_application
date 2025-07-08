package com.example.myapplication.carts_API

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.R

class FullScreenView : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var id: TextView
    private lateinit var title: TextView
    private lateinit var price: TextView
    private lateinit var quantity: TextView
    private lateinit var total: TextView
    private lateinit var discountPercentage: TextView
    private lateinit var discountedTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.full_screen_view)

        imageView = findViewById(R.id.imageView3)
        id = findViewById(R.id.txtId)
        title = findViewById(R.id.txtTitle)
        price = findViewById(R.id.txtPrice)
        quantity = findViewById(R.id.txtQuantity)
        total = findViewById(R.id.txtTotal)
        discountPercentage = findViewById(R.id.txtDiscountPercentage)
        discountedTotal = findViewById(R.id.txtDiscountedTotal)

        val product = intent.getSerializableExtra("product") as? Product

        Log.d("product", "onCreate: $product")

        product?.let {
            Glide.with(this).load(it.thumbnail).into(imageView)
            id.text = "id-->> ${it.id}"
            title.text = "Title-->> ${it.title}"
            price.text = "Price-->> ${it.price}"
            quantity.text = "Quantity-->> ${it.quantity}"
            total.text = "Total-->> ${it.total}"
            discountPercentage.text = "DiscountPercentage-->> ${it.discountPercentage}"
            discountedTotal.text = "DiscountedTotal-->> ${it.discountedTotal}"
        }
    }
}
