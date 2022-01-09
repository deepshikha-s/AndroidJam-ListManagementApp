package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.mymanager.databinding.FragmentHomeBinding

class Home : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentHomeBinding.bind(view)
        binding.todo.setOnClickListener {
            findNavController().navigate(R.id.Tasks)
        }
        binding.notes.setOnClickListener {
            findNavController().navigate(R.id.notes)
        }
        binding.shopping.setOnClickListener {
            findNavController().navigate(R.id.Lists)
        }
    }
}