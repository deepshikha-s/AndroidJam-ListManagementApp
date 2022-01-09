package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.mymanager.databinding.FragmentNotesBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentTasksBinding

class Tasks : Fragment(R.layout.fragment_tasks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentTasksBinding.bind(view)
        binding.newtask.setOnClickListener {
            findNavController().navigate(R.id.addtasks)
        }
    }
}