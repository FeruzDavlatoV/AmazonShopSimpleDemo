package com.example.amazonbeginner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amazonbeginner.databinding.ItemProductBinding

class ProductAdapter(private val products : ArrayList<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val product = products[position]

        holder.binding.apply {
            Glide.with(imageProduct.context).asBitmap().load(product.image).into(imageProduct)
            tvTittleProduct.text = product.name
            tvCategoryProduct.text = product.category
        }
    }

    override fun getItemCount(): Int =  products.size

    class ProductViewHolder(val binding: ItemProductBinding):RecyclerView.ViewHolder(binding.root)


}