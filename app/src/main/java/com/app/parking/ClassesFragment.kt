package com.app.parking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView


class ClassesFragment : Fragment() {
    private var classes : ArrayList<Class> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_classes, container, false)

        val onClickListener = View.OnClickListener { itemView: View ->
            val selectClassId = itemView.tag as Int
            val args = Bundle()
            args.putInt(ARG_CLASS_ID, selectClassId)

            // class details

            Navigation.findNavController(itemView).navigate(R.id.action_class_to_task, args)
        }

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.class_recycler)
        classes = ClassRepository.getInstance(requireContext()).classList
        recyclerView.adapter = ClassAdapter(classes, onClickListener)

        return rootView
    }
    private class ClassAdapter(private val classList: List<Class>,
                               private val onClickListener: View.OnClickListener)
        : RecyclerView.Adapter<ClassHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ClassHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return ClassHolder(layoutInflater, parent)
        }

        override fun onBindViewHolder(holder: ClassHolder, position: Int) {
            val aClass = classList[position]
            holder.bind(aClass)
            holder.itemView.tag = aClass.id
            holder.itemView.setOnClickListener(onClickListener)
        }

        override fun getItemCount(): Int {
            return classList.size
        }
    }

    private class ClassHolder(inflater: LayoutInflater, parent: ViewGroup?) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_assignment, parent, false)) {
            private val nameTextView: TextView

            init {
                nameTextView = itemView.findViewById(R.id.class_name)
            }

            fun bind(aClass: Class) {
                nameTextView.text = aClass.name
            }
        }
}