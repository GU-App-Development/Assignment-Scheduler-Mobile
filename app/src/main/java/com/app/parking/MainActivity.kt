package com.app.parking

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //populate locations with addresses to display for demo
        locations = LocationAddress.createAddressList(7)

        locations.add(0, LocationAddress("1309 W Summit Pkwy", "Spokane, WA 99201"))
        locations.add(1, LocationAddress("1516 W 2nd Ave", "Spokane, WA 99201"))
        locations.add(2, LocationAddress("6022 N Division St", "Spokane, WA 99201"))
        locations.add(3, LocationAddress("621 W Mallon Ave", "Spokane, WA 99201"))
        locations.add(4, LocationAddress("821 W Riverside Ave", "Spokane, WA 99201"))
        locations.add(5, LocationAddress("214 N Howard St", "Spokane, WA 99201"))
        locations.add(6, LocationAddress("916 W 2nd Ave", "Spokane, WA 99201"))

        val rvLocations = findViewById<View>(R.id.address_recycler) as RecyclerView
        rvLocations.setOnClickListener {

        }
        val adapter = AddressAdapter(locations)
        rvLocations.adapter = adapter
        rvLocations.layoutManager = LinearLayoutManager(this)

        // adding nav bar for different activities
//        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//
//        val navController = navHostFragment.navController
//        val appBarConfig = AppBarConfiguration.Builder(
//            R.id.mainActivity, R.id.spotListActivity).build()
//
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig)
//        NavigationUI.setupWithNavController(navView, navController)
    }
}