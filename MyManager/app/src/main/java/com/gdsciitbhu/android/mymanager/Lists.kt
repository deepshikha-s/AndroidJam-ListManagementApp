package com.gdsciitbhu.android.mymanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gdsciitbhu.android.mymanager.databinding.FragmentHomeBinding
import com.gdsciitbhu.android.mymanager.databinding.FragmentListsBinding

class Lists : Fragment(R.layout.fragment_lists) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentListsBinding.bind(view)
        binding.newlist.setOnClickListener {
            //findNavController().navigate(R.id.)
        }
    }
}