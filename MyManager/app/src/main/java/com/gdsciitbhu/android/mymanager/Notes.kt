package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.gdsciitbhu.android.mymanager.databinding.FragmentNotesBinding

class Notes : Fragment(R.layout.fragment_notes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by activityViewModels<NotesViewModel>()
        val binding = FragmentNotesBinding.bind(view)
        binding.newnote.setOnClickListener {
            findNavController().navigate(R.id.addnotes)
        }
        binding.exitnotes.setOnClickListener {
            findNavController().navigate(R.id.Home)
        }
        val adapter = NotesAdapter()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        // pass it to rvLists layoutManager
        binding.notesview.setLayoutManager(layoutManager)
        binding.notesview.adapter = adapter
        viewModel.getList().observe(viewLifecycleOwner){
            adapter.addnote(it)
            adapter.notifyDataSetChanged()
        }


    }
}