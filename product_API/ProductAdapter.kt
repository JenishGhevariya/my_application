package com.example.myapplication.product_Api

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
    private val productList: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgProduct)
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val description: TextView = itemView.findViewById(R.id.txtDescription)
        val rating: TextView = itemView.findViewById(R.id.txtRating)
        val stock: TextView = itemView.findViewById(R.id.txtStock)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]

        holder.txtTitle.text = "Title-->> ${product.title}"
        holder.description.text = "Description-->> ${product.description}"
        holder.txtPrice.text = "Prize-->> ${product.price}₹"
        holder.rating.text = "Rating-->> ${product.rating}"
        holder.stock.text = "Stock-->> ${product.stock}"

        Glide.with(context)
            .load(product.thumbnail)
            .into(holder.imageView)

        holder.imageView.setOnClickListener {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("id", product.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = productList.size
}
