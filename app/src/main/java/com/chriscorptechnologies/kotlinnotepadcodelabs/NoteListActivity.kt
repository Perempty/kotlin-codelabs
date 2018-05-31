package com.chriscorptechnologies.kotlinnotepadcodelabs

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
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
            showNoteDetail(view.tag as Int)
        }
    }

    private fun showNoteDetail(noteIndex: Int) {
        val note = notes[noteIndex]

        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE, note)
        startActivity(intent)
    }


}
