package com.example.roomnoteapp

import MyAdapter
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
//    lateinit var rv: RecyclerView
//    lateinit var ed: EditText
//    lateinit var add: Button
//    lateinit var db: NotesDAO
//    lateinit var NotesList: ArrayList<Note>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        rv = findViewById(R.id.rv)
//        ed = findViewById(R.id.ed)
//        add = findViewById(R.id.add)
//
//
//     add.setOnClickListener {
//            val Notetitle = ed.text.toString()
//
//            val s = db.insertNote(Note(0, Notetitle ))
//         CoroutineScope(IO).launch{
//             NotesDB.getInstance(applicationContext).NotesDao().insertNote(s)
//         }
//
//            Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
//                .show();
//         updateRV()
//        }
//
//    }
//    fun update(s1: Note){
//        var Notetitle=alertDialog()
//        val s = db.updateNote(s1.id, s1.Notetitle )
//        CoroutineScope(IO).launch{
//            NotesDB.getInstance(applicationContext).NotesDao().updateNote(s1)
//        }
//
//        Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
//            .show();
//        updateRV()
//    }


//    fun alertDialog()
//    {
//    val dialogBuilder = AlertDialog.Builder(this)
//    val input = EditText(this)
//    dialogBuilder.setMessage("Enter the new Note: ")
//
//    .setPositiveButton("save", DialogInterface.OnClickListener {
//        dialog,id-> update(input.text.toString())
//
//    })
//    .setNegativeButton("Cancel", DialogInterface.OnClickListener {
//        dialog, id -> dialog.cancel()
//
//    })
//    val edit=dialogBuilder.create()
//    edit.setTitle("Edit Note")
//    edit.setView(input)
//    edit.show()}

//    private fun updateRV() {
//        rv.adapter=MyAdapter(this,NotesList<Note>as ArrayList<String>)
//        rv.layoutManager= LinearLayoutManager(this)
//    }
    }
}