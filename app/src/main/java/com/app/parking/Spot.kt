package com.app.parking

/*
This is the class that we will use to store our data once we make an api request
The spots are "stored" in this class and this data will be used to populate
recycler view
 */

class Spot (val name: String, val pricePerHour : Double){

    companion object {
        fun createParkingList(numSpots: Int) : ArrayList<Spot> {
            val spots = ArrayList<Spot>()
            //TODO: populate array with query results
            return spots
        }
    }

}