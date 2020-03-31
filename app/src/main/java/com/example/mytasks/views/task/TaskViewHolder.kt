package com.example.mytasks.views.task

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytasks.R
import com.example.mytasks.business.database.task.Task

class TaskViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_tasks_item, parent, false)) {

    private var mNameView: TextView? = null
    private var mDescriptionView: TextView? = null
    private var mPriorityView: TextView? = null
    private var mTypeView: TextView? = null
    private var mDateView: TextView? = null

    init {
        mNameView = itemView.findViewById(R.id.list_title)
        mPriorityView = itemView.findViewById(R.id.list_priority)
        mTypeView = itemView.findViewById(R.id.list_type)
        mDateView = itemView.findViewById(R.id.list_date)

    }

    fun bind(task: Task) {
        mNameView?.text = task.name
        val description = task.description
        mPriorityView?.text = task.priority
        mTypeView?.text = task.type
        mDateView?.text = task.creation

        itemView.setOnClickListener {
            val builder = AlertDialog.Builder(itemView.context)

            builder.setTitle("Descrição")

            builder.setMessage(description)

            builder.setNeutralButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }

            val dialog: AlertDialog = builder.create()

            dialog.show()
        }

    }

}