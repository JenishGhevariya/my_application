package com.example.myapplication.carts_API
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartActivity : AppCompatActivity() {

    private lateinit var rvCarts: RecyclerView
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        rvCarts = findViewById(R.id.recyclerView)
        rvCarts.layoutManager = LinearLayoutManager(this)
        fetchCarts()
    }

    private fun fetchCarts() {
        val apiInterfaces = ApiClient.getRetrofitInstance().create(APIInterface::class.java)
        apiInterfaces.getCarts().enqueue(object : Callback<CartResponse> {
            override fun onResponse(call: Call<CartResponse>, response: Response<CartResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    adapter = CartAdapter(this@CartActivity, response.body()!!.carts)
                    rvCarts.adapter = adapter
                } else {
                    Toast.makeText(this@CartActivity, "No carts available", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                Toast.makeText(this@CartActivity, "Error loading carts: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
