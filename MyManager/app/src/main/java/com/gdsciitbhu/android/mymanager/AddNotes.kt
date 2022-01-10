package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.mymanager.databinding.FragmentAddNotesBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentHomeBinding
class AddNotes : Fragment(R.layout.fragment_add_notes) {
    val viewModel by activityViewModels<NotesViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentAddNotesBinding.bind(view)
        binding.exitnote.setOnClickListener {
            findNavController().navigate(R.id.notes)
        }
        binding.createnote.setOnClickListener {
            val note = binding.notetext.text.toString()
            viewModel.addNote(NotesData(note))
            findNavController().navigate(R.id.notes)
        }
    }
}
