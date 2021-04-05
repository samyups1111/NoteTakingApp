package com.example.notes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.util.MainApplication
import com.example.notes.util.MainRecyclerAdapter
import com.example.notes.util.MainViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val mainAdapter = MainRecyclerAdapter()
    private val viewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as MainApplication).mainRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        observeData()
        initRecycler()
        initUI()
    }

    private fun initRecycler() {
        val mainRecycler = findViewById<RecyclerView>(R.id.main_recycler)

        mainRecycler.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        initItemTouchHelper(mainRecycler)
    }

    private fun initUI() {
        val addNoteButton = findViewById<FloatingActionButton>(R.id.add_note_fab)
        addNoteButton.setOnClickListener {
            startActivity(Intent(this, WriteNoteActivity::class.java))
        }
    }

    private fun observeData() {
        viewModel.getNotes.observe(this, Observer {
            mainAdapter.update(it)
        })
    }

    private fun initItemTouchHelper(mainRecycler: RecyclerView) {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder)
                    : Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val notes = mainAdapter.notesList
                viewModel.delete(notes[viewHolder.adapterPosition])
                mainAdapter.notifyDataSetChanged()
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(mainRecycler)
    }
}