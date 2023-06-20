package com.example.todolist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.entity.Notes

@Database(entities = [Notes::class], version = 1)
abstract class RmDatabase : RoomDatabase() {

    abstract fun getNotesDao() : NotesDao




}