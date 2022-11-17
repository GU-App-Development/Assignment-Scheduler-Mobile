package com.app.parking

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//MAPS_API_KEY=AIzaSyDdE_--6YJRNGlZ8fKwcSqU4JQRJv6o9AU

class MainActivity : AppCompatActivity() {
//    // on below line we are
//    // creating variables for listview
//    private lateinit var locationListView: ListView
//
//    // creating array adapter for listview
//    lateinit var listAdapter: ArrayAdapter<String>

    //an array list of locations to select from based on your query
    lateinit var locations : ArrayList<LocationAddress>

    // creating array list for listview
    lateinit var locationList: ArrayList<String>

    // creating variable for search view
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing variables of list view with their ids.
//        locationListView = findViewById(R.id.location_list_view)
        val locationAddress = findViewById<View>(R.id.address_recycler) as RecyclerView
        searchView = findViewById(R.id.search_view)

//        // initializing list and adding data to list
//        locationList = ArrayList()
//        locationList.add("Spokane")

//        // initializing list adapter and setting layout
//        // for each list view item and adding array list to it.
//        listAdapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1,
//            locationList
//        )

//        // on below line setting list
//        // adapter to our list view.
//        locationListView.adapter = listAdapter

        //populate data

        //adapter for the locations
        val adapter = AddressAdapter(locations)
        locationAddress.adapter = adapter
        locationAddress.layoutManager = LinearLayoutManager(this)

        // on below line we are adding on query
        // listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (locationList.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    listAdapter.filter.filter(query)
                } else {
                    // if query is not present we are displaying
                    // a toast message as no  data found..
                    Toast.makeText(this@MainActivity, "Location not found..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                listAdapter.filter.filter(newText)
                return false
            }
        })
    }
}