package com.example.todolist.data.repo

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.MutableLiveData
import com.example.todolist.data.entity.Notes
import com.example.todolist.room.NotesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesDaoRepository(var nDao: NotesDao) {

    var notesList: MutableLiveData<List<Notes>>

    init {
        notesList= MutableLiveData()
    }

    fun returnNotes() : MutableLiveData<List<Notes>>{
        return notesList
    }

    fun saveNote(noteTitle:String, note:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val newNote= Notes(0,noteTitle,note)
            nDao.saveNote(newNote)
        }
    }

    fun searchNote(searchedText: String){
        val job= CoroutineScope(Dispatchers.Main).launch {

            notesList.value= nDao.searchNotes(searchedText)

        }
    }

    fun deleteNote(note_id:Int){
        val job= CoroutineScope(Dispatchers.Main).launch {
            val deletedNote= Notes(note_id,"","")
            nDao.deleteNote(deletedNote)
            getAllNotes()
        }
    }

    fun getAllNotes(){
        val job= CoroutineScope(Dispatchers.Main).launch {

            notesList.value= nDao.getAllnotes()

        }
    }
}