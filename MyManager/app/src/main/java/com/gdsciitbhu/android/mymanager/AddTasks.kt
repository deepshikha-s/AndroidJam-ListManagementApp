package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.mymanager.databinding.FragmentAddNotesBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentAddTasksBinding

class AddTasks : Fragment(R.layout.fragment_add_tasks) {
    val viewModel by activityViewModels<TasksViewModel>()
    var category= ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentAddTasksBinding.bind(view)
        binding.exittask.setOnClickListener {
            findNavController().navigate(R.id.Tasks)
        }
        binding.createtask.setOnClickListener {
            val task = binding.tasktext.text.toString()
            val date = binding.duetime.text.toString()
            val category = binding.category.text.toString()
            viewModel.addTask(TasksData(task, date, category))
            findNavController().navigate(R.id.Tasks)
        }
    }
}