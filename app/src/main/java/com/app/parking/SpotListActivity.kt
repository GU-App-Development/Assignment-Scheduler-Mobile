package com.app.parking

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
This is where we bind the data we got from the adapter to the recycler view
 */
class SpotListActivity : AppCompatActivity(){
    lateinit var spots : ArrayList<Spot>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //connect to the recycler view
        val rvSpots = findViewById<View>(R.id.recyclerview) as RecyclerView
        //make list of 5
        //TODO populate spots with query data
        spots = Spot.createParkingList(15) //initializes contacts
        //instantiate adapter and pass in the spots data
        val adapter = SpotAdapter(spots)
        rvSpots.adapter = adapter
        rvSpots.layoutManager = LinearLayoutManager(this)
    }
}