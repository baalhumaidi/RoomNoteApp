package com.example.roomnoteapp

import MyAdapter
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class fragment_note : Fragment() {

    lateinit var rv: RecyclerView
    lateinit var ed: EditText
    lateinit var add: Button
    lateinit var db: NotesDAO
    lateinit var sh: SharedPreferences
 //   lateinit var NotesList: ArrayList<Note>
    private val MyViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    lateinit var rvadapter: MyAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_note, container, false)
        rv = view.findViewById(R.id.rv)
        ed = view.findViewById(R.id.ed)
        add = view.findViewById(R.id.add)
        rvadapter = MyAdapter(this, emptyList())
        rv.adapter = rvadapter

        rv.layoutManager = LinearLayoutManager(requireContext())
        sh = requireActivity().getSharedPreferences("MyNotes", Context.MODE_PRIVATE)

        MyViewModel.getNotes().observe(viewLifecycleOwner, { NotesList ->
            rvadapter.updateMyAdapter(NotesList)

        })
        add.setOnClickListener {
            val Notetitle = ed.text.toString()
            if (Notetitle.isNotEmpty()) {
              MyViewModel.insertNote(Note(0,Notetitle))
                ed.text.clear()
                ed.clearFocus()}

             else
                Toast.makeText(requireContext(), "should not be empty", Toast.LENGTH_LONG).show()
        }

        return view
    }

    fun gotoupdate()
    {
        Navigation.findNavController(requireView()).navigate(R.id.action_fragment_note_to_fragment_update)

    }
    fun deletenote(note: Note){
        val builder1 = AlertDialog.Builder(requireContext())
        builder1.setMessage("Are you sure?")
        builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
            MyViewModel.deleteNote(note)
        })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })
        val delete = builder1.create()
        delete.setTitle("Delete")
        delete.show()
    }
    fun insertNote(){
        val note = ed.text.toString()
        if(note.isNotEmpty()){
            MyViewModel.insertNote(Note(0, note))
            ed.text.clear()
            ed.clearFocus()
        }
        else{
            Toast.makeText(requireContext(), "you should add note", Toast.LENGTH_SHORT).show()
        }
    }
    }


