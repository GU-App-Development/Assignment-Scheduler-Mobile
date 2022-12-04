package com.app.parking

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
public class UserClass(val name : String = "", val classId : Int) : Parcelable {
    var taskList : ArrayList<Task> = ArrayList()
}