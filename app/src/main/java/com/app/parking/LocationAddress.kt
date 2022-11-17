package com.app.parking

class LocationAddress(val address: String, val csz: String) {
    companion object {
        fun createAddressList(numLocations: Int) : ArrayList<LocationAddress> {
            val addresses = ArrayList<LocationAddress>()
            return addresses
        }
    }
}