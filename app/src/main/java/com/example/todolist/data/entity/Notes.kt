package com.example.todolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("note_id") @NotNull var note_id:Int,
    @ColumnInfo("noteTitle") @NotNull var noteTitle:String,
    @ColumnInfo("note") @NotNull var note:String
) : java.io.Serializable{}
