package com.app.parking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AddressAdapter(private val addresses: List<LocationAddress>) : RecyclerView.Adapter<AddressAdapter.ViewHolder>() {
    //access the views
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addressNameTV = itemView.findViewById<TextView>(R.id.address)
        val cszTV = itemView.findViewById<TextView>(R.id.city_state_zip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //inflate the layout
        val addressView = inflater.inflate(R.layout.address_item, parent, false)
        return ViewHolder(addressView)
    }

    //set text within each item view
    override fun onBindViewHolder(viewHolder: AddressAdapter.ViewHolder, position: Int) {
        val address: LocationAddress = addresses.get(position)
        val streetAddress = viewHolder.addressNameTV
        streetAddress.text = address.address
        val csz = viewHolder.cszTV
        csz.text = address.csz
    }

    override fun getItemCount(): Int {
        return addresses.size
    }
}