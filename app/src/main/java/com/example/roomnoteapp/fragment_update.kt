package com.example.roomnoteapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class fragment_update : Fragment() {

    private val MyViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    lateinit var sh: SharedPreferences
    lateinit var ed1: EditText
    lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_update, container, false)
        ed1=view.findViewById(R.id.ed1)
        sh = requireActivity().getSharedPreferences("MyNotes", Context.MODE_PRIVATE)
        button=view.findViewById(R.id.button)
        button.setOnClickListener {
            var newnote=ed1.text.toString()
            if (newnote.isNotEmpty()) {
               MyViewModel.updateNote(Note(sh.getInt("ID",0), ed1.text.toString()))
//                ed1.text.clear()
                ed1.clearFocus()
                Navigation.findNavController(view).navigate(R.id.action_fragment_update_to_fragment_note)
            }

                else
            {
                Toast.makeText(requireContext(), "its empty", Toast.LENGTH_SHORT).show()
        }}


  return view
    }


}