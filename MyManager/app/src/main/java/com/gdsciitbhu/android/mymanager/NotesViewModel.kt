package com.gdsciitbhu.android.mymanager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {
    val notelist = MutableLiveData(emptyList<NotesData>())
    fun addNote(note: NotesData){
        notelist.value = notelist.value!! + note
    }

    fun getList(): MutableLiveData<List<NotesData>> {
        return notelist
    }
}