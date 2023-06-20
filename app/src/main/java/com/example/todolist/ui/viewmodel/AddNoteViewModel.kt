package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolist.data.repo.NotesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor (var nRepo: NotesDaoRepository)  : ViewModel() {


    fun save(noteTitle:String, note:String){
        nRepo.saveNote(noteTitle,note)
    }
}