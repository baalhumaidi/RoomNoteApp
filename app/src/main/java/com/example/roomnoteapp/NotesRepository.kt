package com.example.roomnoteapp

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDAO: NotesDAO) {
//  val Note: LiveData<List<Note>> = notesDAO.getAllNotes()



  suspend  fun insertNote(note: Note)
  {
    notesDAO.insertNote(note)
  }

  suspend  fun updateNote(note: Note)
  {
    notesDAO.updateNote(note)
  }


  suspend fun deleteNote(note: Note)
  {
    notesDAO.deleteNote(note)
  }

}