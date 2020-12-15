package com.rica.blackdog.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parse.ParseObject
import com.rica.blackdog.R
import com.rica.blackdog.interfaces.HomeInterface
import com.rica.blackdog.interfaces.ProductsInterface

class ProductsAdapter
    (
    private val context: Context,
    private val mData: ArrayList<ParseObject>,
    private val mInterface: ProductsInterface
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private val mInflater: LayoutInflater

    init {
        this.mInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_product_list, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: ParseObject = mData[position]

        if (item.has("name")) {
            holder.name.text = item.getString("name")
        }
        if (item.has("img")) {
            Glide.with(context)
                .load(item.getParseFile("img").url)
                .into(holder.img)
        }
        if (item.has("price")){
            holder.price.text = "$ ${item.get("price")} MXN"
        }

    }


    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var price: TextView
        var img: ImageView

        init {
            name = itemView.findViewById(R.id.name)
            price = itemView.findViewById(R.id.price)
            img = itemView.findViewById(R.id.img)
        }
    }
}