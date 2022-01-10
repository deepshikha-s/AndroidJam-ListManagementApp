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
import com.gdsciitbhu.android.mymanager.databinding.FragmentHomeBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentListsBinding

class Lists : Fragment(R.layout.fragment_lists) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentListsBinding.bind(view)
        val viewModel by activityViewModels<ListsViewModel>()
        val adapter = ListAdapter()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.newlist.setOnClickListener {
            var ld  = ListsData(binding.listitem.text.toString(), true)
            viewModel.addList(ld)
            // pass it to rvLists layoutManager
            binding.listview.setLayoutManager(layoutManager)
            binding.listview.adapter = adapter
            viewModel.getList().observe(viewLifecycleOwner){
                adapter.addlist(it)
                adapter.notifyDataSetChanged()
            }
        }
        /*binding.newlist.setOnClickListener {
            // pass it to rvLists layoutManager
            binding.listview.setLayoutManager(layoutManager)
            binding.listview.adapter = adapter
            viewModel.getList().observe(viewLifecycleOwner){
                adapter.addlist(it)
                adapter.notifyDataSetChanged()
            }


        }

         */
    }
}