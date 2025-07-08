package com.example.myapplication.product_Api
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var apiInterface: APIInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.setHasFixedSize(true)

        apiInterface = ApiClient.getClient().create(APIInterface::class.java)
        fetchProducts()
    }

    private fun fetchProducts() {
        val call: Call<ProductsResponseModel> = apiInterface.getProducts()
        call.enqueue(object : Callback<ProductsResponseModel> {
            override fun onResponse(
                call: Call<ProductsResponseModel>,
                response: Response<ProductsResponseModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val products = response.body()!!.products
                    val adapter = ProductAdapter(this@MainActivity3, products)
                    recyclerView.adapter = adapter
                    Log.d("response", "onResponse: ${products[0].thumbnail}")
                }
            }
            override fun onFailure(call: Call<ProductsResponseModel>, t: Throwable) {
                Toast.makeText(this@MainActivity3, "Failed to load", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
