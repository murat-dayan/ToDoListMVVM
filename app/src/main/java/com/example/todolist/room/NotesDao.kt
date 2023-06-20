package com.example.todolist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.data.entity.Notes

@Dao
interface NotesDao {

    @Query("SELECT*FROM notes")
    suspend fun getAllnotes() : List<Notes>

    @Query("SELECT*FROM notes WHERE noteTitle LIKE '%' || :searchedWord ||'%'")
    suspend fun searchNotes(searchedWord:String): List<Notes>

    @Insert
    suspend fun saveNote(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)


}