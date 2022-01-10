package com.gdsciitbhu.android.mymanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TasksViewModel: ViewModel() {
    val taskslist = MutableLiveData(emptyList<TasksData>())
    fun addTask(task: TasksData){
        taskslist.value = taskslist.value!! + task
    }

    fun getList(): MutableLiveData<List<TasksData>> {
        return taskslist
    }
}