package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.mymanager.databinding.FragmentHomeBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentNotesBinding

class Notes : Fragment(R.layout.fragment_notes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by activityViewModels<NotesViewholder> {  }
        val binding = FragmentNotesBinding.bind(view)
        binding.newnote.setOnClickListener {
            findNavController().navigate(R.id.addnotes)
        }
        val adapter = NotesAdapter()
        binding.notesview.adapter = adapter

    }
}