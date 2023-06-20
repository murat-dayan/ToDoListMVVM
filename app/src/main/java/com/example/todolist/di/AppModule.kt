package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.todolist.data.repo.NotesDaoRepository
import com.example.todolist.room.NotesDao
import com.example.todolist.room.RmDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesNotesDaoRepository(nDao: NotesDao) : NotesDaoRepository{
        return NotesDaoRepository(nDao)
    }

    @Provides
    @Singleton
    fun providesNotesDao(@ApplicationContext context: Context) : NotesDao{

        val rmDb= Room.databaseBuilder(context, RmDatabase::class.java,"todolist.sqlite")
            .createFromAsset("todolist.sqlite").build()
        return rmDb.getNotesDao()
    }



}