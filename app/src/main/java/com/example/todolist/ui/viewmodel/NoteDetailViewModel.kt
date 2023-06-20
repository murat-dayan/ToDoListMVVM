package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolist.data.repo.NotesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor (var nRepo: NotesDaoRepository)  : ViewModel() {


}