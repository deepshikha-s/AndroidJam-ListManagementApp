package com.gdsciitbhu.android.mymanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.mymanager.databinding.NotesItemBinding

class NotesAdapter: RecyclerView.Adapter<NotesViewholder>() {
    val notesList = mutableListOf<String>()
    fun addnote(todo:String){
        notesList.add(todo)
        notifyItemInserted(notesList.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NotesItemBinding.inflate(inflater, parent, false)
        return NotesViewholder(binding)
        }

        override fun onBindViewHolder(holder: NotesViewholder, position: Int) {
            holder.binding.todo.text = notesList[position]
        }

        override fun getItemCount(): Int {
            return notesList.size
        }

    }
class NotesViewholder(val binding: NotesItemBinding) : RecyclerView.ViewHolder(binding.root){

}


