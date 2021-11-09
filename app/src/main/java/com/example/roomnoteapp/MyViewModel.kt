package com.example.roomnoteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel(activity: Application) : AndroidViewModel(activity) {

    private val notesArray: LiveData<List<Note>>
    private val notesDao = NotesDB.getInstance(activity).NotesDao()
//    private val repoNote: NotesRepository

    init {

//        repoNote = NotesRepository(notesDao)
        notesArray = notesDao.getAllNotes()
    }

    fun getNotes(): LiveData<List<Note>> {
        return notesArray
    }

    fun insertNote(note: Note) {

        GlobalScope.launch(Dispatchers.IO) {
            notesDao.insertNote(note)

        }
    }

    fun updateNote(note: Note) {
        GlobalScope.launch(Dispatchers.IO) {
            notesDao.updateNote(note)

        }
    }

    fun deleteNote(note: Note) {
        GlobalScope.launch(Dispatchers.IO) {

            notesDao.deleteNote(note)

        }
    }


}