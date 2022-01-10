package com.gdsciitbhu.android.mymanager

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gdsciitbhu.android.mymanager.databinding.ListsItemBinding

class ListAdapter: RecyclerView.Adapter<ListsViewholder>() {
    var listsList = emptyList<ListsData>()
    fun addlist(list:List<ListsData>){
        listsList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListsViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListsItemBinding.inflate(inflater, parent, false)
        return ListsViewholder(binding)
    }

    fun strikeThrough(listtext: TextView, isChecked: Boolean){
        if(isChecked){
            listtext.paintFlags = listtext.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
        else{
            listtext.paintFlags = listtext.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
    }

    override fun onBindViewHolder(holder: ListsViewholder, position: Int) {
        var text = holder.binding.textView
        var box = holder.binding.checkBox2
        text.text = listsList[position].list
        box.isChecked = listsList[position].isChecked
        strikeThrough(text, box.isChecked)
        box.setOnCheckedChangeListener { _, isChecked ->
            strikeThrough(text, box.isChecked)
            box.isChecked = !box.isChecked
        }
    }

    override fun getItemCount(): Int {
        return listsList.size
    }

}
class ListsViewholder(val binding: ListsItemBinding) : RecyclerView.ViewHolder(binding.root){

}