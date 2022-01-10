package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.mymanager.databinding.FragmentNotesBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentTasksBinding

class Tasks : Fragment(R.layout.fragment_tasks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by activityViewModels<TasksViewModel>()
        val binding = FragmentTasksBinding.bind(view)
        binding.newtask.setOnClickListener {
            findNavController().navigate(R.id.addtasks)
        }
        binding.exittasks.setOnClickListener{
            findNavController().navigate(R.id.Home)
        }
        val adapter = TasksAdapter()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rvLists layoutManager
        binding.incompletetasks.setLayoutManager(layoutManager)
        binding.incompletetasks.adapter = adapter
        viewModel.getList().observe(viewLifecycleOwner){
            adapter.addtask(it)
            adapter.notifyDataSetChanged()
        }

    }
}