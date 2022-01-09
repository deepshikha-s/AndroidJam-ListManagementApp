package com.gdsciitbhu.android.mymanager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class NotesViewModel : ViewModel() {
    val notelist = MutableLiveData(emptyList<>())
}