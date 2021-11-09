package com.example.roomnoteapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class],version = 1,exportSchema = false)


abstract class NotesDB: RoomDatabase() {

    companion object{
        var instance:NotesDB?=null;
        fun getInstance(ctx: Context):NotesDB
        {
            if(instance!=null)
            {
                return  instance as NotesDB;
            }
            instance= Room.databaseBuilder(ctx,NotesDB::class.java,"somename").run { allowMainThreadQueries() }.build();
            return instance as NotesDB;
        }
    }
    abstract fun NotesDao():NotesDAO;
}