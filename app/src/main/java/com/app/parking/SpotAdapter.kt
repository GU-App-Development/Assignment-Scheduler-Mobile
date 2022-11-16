package com.app.parking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpotAdapter(private val spots: List<Spot>) : RecyclerView.Adapter<SpotAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // for any view that will be set as you render a row
        val spotNameTV = itemView.findViewById<TextView>(R.id.spot_name)
        val priceTV = itemView.findViewById<TextView>(R.id.spot_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //inflate the individual spot layout
        val spotView = inflater.inflate(R.layout.item_spot, parent, false)
        //returns a new holder instance
        return ViewHolder(spotView)
    }

    //populates data into the item via holder
    override fun onBindViewHolder(viewHolder: SpotAdapter.ViewHolder, position: Int) {
        val spot: Spot = spots.get(position)
        //set the spot name
        val spotName = viewHolder.spotNameTV
        spotName.text = spot.name
        //set the spot price
        val price = viewHolder.priceTV
        price.text = (spot.pricePerHour).toString()
    }

    override fun getItemCount(): Int {
        return spots.size
    }
}