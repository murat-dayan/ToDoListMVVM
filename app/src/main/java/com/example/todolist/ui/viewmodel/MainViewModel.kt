package com.example.todolist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.entity.Notes
import com.example.todolist.data.repo.NotesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (var nRepo: NotesDaoRepository) : ViewModel() {

    var notesList= MutableLiveData<List<Notes>>()

    init {
        loadNotes()
        notesList= nRepo.returnNotes()
    }



    fun search(searchedText: String){
        nRepo.searchNote(searchedText)
    }

    fun delete(note_id:Int){
        nRepo.deleteNote(note_id)
    }

    fun loadNotes(){
        nRepo.getAllNotes()
    }
}