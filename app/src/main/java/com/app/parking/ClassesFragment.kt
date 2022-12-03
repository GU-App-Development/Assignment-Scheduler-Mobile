package com.app.parking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ClassesFragment : Fragment() {
    var classes : ArrayList<Class> = ArrayList<Class>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_classes, container, false)

        val onClickListener = View.OnClickListener { itemView: View ->
            val selectClassId = itemView.tag as Int
            val args = Bundle()
            args.putInt(ARG_CLASS_ID, selectClassId)

        }

        return rootView
    }

}