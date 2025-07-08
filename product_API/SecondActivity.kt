package com.example.myapplication.product_Api

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var titleText: TextView
    private lateinit var priceText: TextView
    private lateinit var id: TextView
    private lateinit var rating: TextView
    private lateinit var stock: TextView
    private lateinit var category: TextView
    private lateinit var description: TextView
    private lateinit var brand: TextView
    private lateinit var warranty: TextView
    private lateinit var comment: TextView

    private lateinit var apiInterface: APIInterface
    private var productId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        imageView = findViewById(R.id.imageView)
        id = findViewById(R.id.text_id)
        titleText = findViewById(R.id.text_title)
        description = findViewById(R.id.text_description)
        rating = findViewById(R.id.text_rating)
        category = findViewById(R.id.text_category)
        stock = findViewById(R.id.text_stock)
        priceText = findViewById(R.id.textPrice)
        brand = findViewById(R.id.text_brand)
        warranty = findViewById(R.id.text_warranty)
        comment = findViewById(R.id.text_comment)

        productId = intent.getIntExtra("id", 0)

        apiInterface = ApiClient.getClient().create(APIInterface::class.java)
        fetchProductById()
    }

    private fun fetchProductById() {
        val call: Call<ProductSecondScreen> = apiInterface.getProductById(productId)
        call.enqueue(object : Callback<ProductSecondScreen> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<ProductSecondScreen>, response: Response<ProductSecondScreen>) {
                if (response.isSuccessful && response.body() != null) {
                    val product = response.body()!!
                    Log.d("API_RESPONSE", Gson().toJson(product))

                    id.text = "id-->> ${product.id}"
                    titleText.text = "title-->> ${product.title}"
                    description.text = "description-->> ${product.description}"
                    rating.text = "rating-->> ${product.rating}"
                    category.text = "category-->> ${product.category}"
                    priceText.text = "price-->> ${product.price}₹"
                    stock.text = "Stock-->> ${product.stock}"
                    brand.text = "brand-->> ${product.brand}"
                    warranty.text = "warranty-- >> ${product.warrantyInformation}"

                    comment.text = if (!product.reviews.isNullOrEmpty()) {
                        "comment-->> ${product.reviews[0].comment}"
                    } else {
                        "comment-->> N/A"
                    }

                    if (!product.images.isNullOrEmpty()) {
                        Glide.with(this@SecondActivity)
                            .load(product.images[0])
                            .placeholder(R.drawable.placeholder)
                            .error(R.drawable.error_image)
                            .into(imageView)
                    } else {
                        imageView.setImageResource(R.drawable.error_image)
                    }
                } else {
                    Toast.makeText(this@SecondActivity, "No data found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProductSecondScreen>, t: Throwable) {
                Toast.makeText(this@SecondActivity, "Failed to load product", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
