package com.app.parking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

const val ARG_CLASS_ID = "class_id"

class TasksFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_classes, container, false)

        val onClickListener = View.OnClickListener { itemView : View ->

        }
        view?.findViewById<Button>(R.id.class_name)?.setOnClickListener{

        }

        return rootView
    }
}