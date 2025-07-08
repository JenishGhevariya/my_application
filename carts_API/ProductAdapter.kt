package com.example.myapplication.carts_API

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R

class ProductAdapter(
    private val context: Context,
    private val products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.tvID.text = "ID -- >> ${product.id}"
        holder.tvTitle.text = "Title -- >> ${product.title}"
        holder.tvPrice.text = "Price -- >> $${product.price}"
        holder.tvQuantity.text = "Quantity -- >> ${product.quantity}"

        Glide.with(context).load(product.thumbnail).into(holder.imageView)
        holder.imageView.setOnClickListener {
            val intent = Intent(context, FullScreenView::class.java).apply {
                putExtra("product", product)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgProduct1)
        val tvID: TextView = itemView.findViewById(R.id.tvID)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
    }
}
