package com.app.parking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class TasksFragment : Frargment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_classes, container, false)

        val onClickListener = View.OnClickListener { itemView : View ->

        }
        getView()?.findViewById<Button>(R.id.add_button).setOnClickListener{

        }
    }
}