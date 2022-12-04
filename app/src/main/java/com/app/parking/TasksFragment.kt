package com.app.parking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import java.time.LocalDate

const val ARG_CLASS_ID = "class_name"

class TasksFragment : Fragment(){

    private var userClass: UserClass? = null
    var className = "App Dev"
    var classesList : ArrayList<UserClass> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {className = it.getString(ARG_CLASS_ID).toString()}
        arguments?.let { classesList = it.getParcelableArrayList("classes_list")!! }

        for(item in classesList) {
            if(item.name == className) {
                userClass = item
            }
        }

        userClass?.taskList?.add(Task("Quiz 1", LocalDate.of(2022, 11, 1), TASK_TYPE.QUIZ))
        userClass?.taskList?.add(Task("Homework 3", LocalDate.of(2022, 11, 3), TASK_TYPE.ASSIGNMENT))
        userClass?.taskList?.add(Task("Unit 5 Exam", LocalDate.of(2022, 11, 25), TASK_TYPE.EXAM))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_tasks, container, false)

        if (userClass != null) {

        }

        return rootView
    }

    private class TaskAdapter(private val tasks : ArrayList<Task>) :
        RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

        inner class  MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var itemName : TextView = view.findViewById<TextView>(R.id.task_title)
            var itemDate : TextView = view.findViewById<TextView>(R.id.due_date)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
            return MyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val item = tasks[position]
            holder.itemName.text = item.name
            holder.itemDate.text = item.dueDate.toString()

        }

        override fun getItemCount(): Int {
            return tasks.size
        }
    }
}