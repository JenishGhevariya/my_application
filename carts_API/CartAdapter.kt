package com.example.myapplication.carts_API

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CartAdapter(
    private val context: Context,
    private val cartList: List<Cart>
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cart = cartList[position]
        holder.tvCartId.text = "Carts id -->> ${cart.id}"
        holder.tvUserId.text = "User id -->> ${cart.userId}"
        holder.tvTotal.text = "Total -->> $${cart.total}"
        holder.tvDiscountedTotal.text = "DiscountedTotal -->> ${cart.discountedTotal}"

        val productAdapter = ProductAdapter(context, cart.products)
        holder.rvProducts.layoutManager = LinearLayoutManager(context)
        holder.rvProducts.adapter = productAdapter
    }
    override fun getItemCount(): Int = cartList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvProducts: RecyclerView = itemView.findViewById(R.id.rvProducts)
        val tvCartId: TextView = itemView.findViewById(R.id.tvCartId)
        val tvUserId: TextView = itemView.findViewById(R.id.tvUserId)
        val tvTotal: TextView = itemView.findViewById(R.id.tvTotal)
        val tvDiscountedTotal: TextView = itemView.findViewById(R.id.tvDiscountedTotal)
    }
}
