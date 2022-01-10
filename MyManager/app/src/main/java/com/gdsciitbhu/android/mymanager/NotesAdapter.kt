package com.gdsciitbhu.android.mymanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.mymanager.databinding.NotesItemBinding

class NotesAdapter: RecyclerView.Adapter<NotesViewholder>() {
    var notesList = emptyList<NotesData>()
    fun addnote(note:List<NotesData>){
        notesList = note
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NotesItemBinding.inflate(inflater, parent, false)
        return NotesViewholder(binding)
        }

        override fun onBindViewHolder(holder: NotesViewholder, position: Int) {
            holder.binding.notetext.text = notesList[position].notes
        }

        override fun getItemCount(): Int {
            return notesList.size
        }

    }
class NotesViewholder(val binding: NotesItemBinding) : RecyclerView.ViewHolder(binding.root){

}


