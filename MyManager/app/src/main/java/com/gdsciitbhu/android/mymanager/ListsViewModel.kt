package com.gdsciitbhu.android.mymanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListsViewModel: ViewModel() {
    val listlist = MutableLiveData(emptyList<ListsData>())
    fun addList(list: ListsData){
        listlist.value = listlist.value!! + list
    }

    fun getList(): MutableLiveData<List<ListsData>> {
        return listlist
    }
}