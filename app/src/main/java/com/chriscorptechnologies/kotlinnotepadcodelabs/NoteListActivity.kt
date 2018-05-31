package com.chriscorptechnologies.kotlinnotepadcodelabs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        notes = mutableListOf<Note>()
        notes.add(Note("Note 1", "Blablalalala"))
        notes.add(Note("Note 2", "Christophe"))
        notes.add(Note("Note 3", "Future champion de Kotlin"))
        notes.add(Note("Note 4", "Blablalalala"))
        notes.add(Note("Note 5", "Blablalalala"))

        adapter = NoteAdapter(notes, this)

        val recyclerView = notes_recycler_view as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    override fun onClick(view: View) {

        if(view.tag != null) {
            Toast.makeText(this, "Click sur une note de la liste", Toast.LENGTH_SHORT).show()
        }
    }

}
