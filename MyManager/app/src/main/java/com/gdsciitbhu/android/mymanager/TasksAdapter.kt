package com.gdsciitbhu.android.mymanager

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.mymanager.databinding.NotesItemBinding
import com.gdsciitbhu.android.mymanager.databinding.TasksItemBinding

class TasksAdapter: RecyclerView.Adapter<TasksViewholder>() {
    var tasksList = emptyList<TasksData>()
    fun addtask(task:List<TasksData>){
        tasksList = task
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TasksItemBinding.inflate(inflater, parent, false)
        return TasksViewholder(binding)
    }
    fun strikeThrough(tasktext: TextView, taskdate: TextView, taskcategory: TextView, isChecked: Boolean){
        if(isChecked){
            tasktext.paintFlags = tasktext.paintFlags or STRIKE_THRU_TEXT_FLAG
            taskdate.paintFlags = taskdate.paintFlags or STRIKE_THRU_TEXT_FLAG
            taskcategory.paintFlags = taskcategory.paintFlags or STRIKE_THRU_TEXT_FLAG
        }
        else{
            tasktext.paintFlags = tasktext.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
            taskdate.paintFlags = taskdate.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
            taskcategory.paintFlags = taskcategory.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
    override fun onBindViewHolder(holder: TasksViewholder, position: Int) {
        var text = holder.binding.tasktext
        var date = holder.binding.taskdate
        var category = holder.binding.taskcategory
        var box = holder.binding.checkBox
        text.text = tasksList[position].task
        date.text = tasksList[position].date
        category.text = tasksList[position].cat
        box.isChecked = tasksList[position].isChecked
        strikeThrough(text, date, category, box.isChecked)
        box.setOnCheckedChangeListener { _, isChecked ->
            strikeThrough(text, date, category, box.isChecked)
            box.isChecked = !box.isChecked
        }
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

}
class TasksViewholder(val binding: TasksItemBinding) : RecyclerView.ViewHolder(binding.root){

}