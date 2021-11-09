package com.example.roomnoteapp

import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDAO {
   @Query("SELECT * FROM Note ")
     fun getAllNotes(): LiveData<List<Note>>

     @Query("")
    @Insert
    suspend fun insertNote(note: Note)

    //@Query ("Update Note SET Notetitle=:n WHERE id=:id")
    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}