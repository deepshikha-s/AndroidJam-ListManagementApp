package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.mymanager.databinding.FragmentAddNotesBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentAddTasksBinding

class AddTasks : Fragment(R.layout.fragment_add_tasks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentAddTasksBinding.bind(view)
        binding.exittask.setOnClickListener {
            findNavController().navigate(R.id.Tasks)
        }
        binding.createtask.setOnClickListener {
            findNavController().navigate(R.id.Tasks)
        }
    }
}