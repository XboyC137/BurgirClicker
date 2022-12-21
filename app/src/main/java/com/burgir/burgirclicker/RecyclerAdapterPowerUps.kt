package com.burgir.burgirclicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterPowerUps: RecyclerView.Adapter<RecyclerAdapterPowerUps.ViewHolder>() {


    private var itemNames = arrayOf("Dirt Spatula", "Wooden Spatula", "Stone Spatula", "Iron Spatula", "Gold Spatula", "Diamond Spatula")
    private var itemPrices = arrayOf(500, 1000, 2000, 4000, 8000, 16000)
    private var itemAttributes = arrayOf("Click", "Click", "Click", "Click", "Click", "Click")
    private var itemModifiers = arrayOf(2, 3, 4, 5, 6, 7)

    private var itemImages = intArrayOf(R.drawable.dirt_spat, R.drawable.wooden_spat, R.drawable.stone_spat, R.drawable.iron_spat,
                                        R.drawable.gold_spat, R.drawable.diamond_spat)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterPowerUps.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.power_ups_cardview, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemNames.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapterPowerUps.ViewHolder, position: Int) {
        holder.itemImage.setImageResource(itemImages[position])
        holder.itemName.text = itemNames[position]
        holder.itemPrice.text = itemPrices[position].toString()
        holder.itemAttribute.text = itemAttributes[position]
        holder.itemModifier.text = itemModifiers[position].toString()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemName: TextView
        var itemPrice: TextView
        var itemAttribute: TextView
        var itemModifier: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemName = itemView.findViewById(R.id.item_name)
            itemPrice = itemView.findViewById(R.id.price)
            itemAttribute = itemView.findViewById(R.id.attribute)
            itemModifier = itemView.findViewById(R.id.modifier)
        }

    }


}