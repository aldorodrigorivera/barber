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
import com.rica.blackdog.interfaces.PointsOfSaleInterface

class PointsAdapter
    (
    private val context: Context,
    private val mData: ArrayList<ParseObject>,
    private val mInterface: PointsOfSaleInterface
) : RecyclerView.Adapter<PointsAdapter.ViewHolder>() {

    private val mInflater: LayoutInflater

    init {
        this.mInflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_points_list, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: ParseObject = mData[position]

        if (item.has("name")) {
            holder.name.text = item.getString("name").toUpperCase()
        }
        if (item.has("img")) {
            Glide.with(context)
                .load(item.getParseFile("img").url)
                .into(holder.img)
        }
        if (item.has("address")){
            holder.address.text = item.getString("address")
        }
        if (item.has("phone")){
            holder.phone.text = item.getString("phone")
        }

        holder.card.setOnClickListener {
            mInterface.onClick(item)
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
        var address: TextView
        var phone: TextView
        var img: ImageView
        var card: CardView

        init {
            name = itemView.findViewById(R.id.name)
            phone = itemView.findViewById(R.id.phone)
            address = itemView.findViewById(R.id.address)
            img = itemView.findViewById(R.id.img)
            card = itemView.findViewById(R.id.card)
        }
    }
}