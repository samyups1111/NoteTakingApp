package com.example.notes.util

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.model.Note
import com.example.notes.ui.WriteNoteActivity

class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.title_textview)
    private val messageTextView: TextView = itemView.findViewById(R.id.message_textview)
    private val idTextView: TextView = itemView.findViewById(R.id.id_textview)

    fun bind(note: Note) {
        titleTextView.text = note.title
        messageTextView.text = note.message
        idTextView.text = note.id.toString()

        titleTextView.setOnClickListener {
            val currentTitle = titleTextView.text.toString()
            val currentMessage = messageTextView.text.toString()
            val currentId = idTextView.text.toString()

            val writeNoteIntent = Intent(itemView.context, WriteNoteActivity::class.java)

            writeNoteIntent.putExtra("title", currentTitle)
            writeNoteIntent.putExtra("message", currentMessage)
            writeNoteIntent.putExtra("id", currentId)

            itemView.context.startActivity(writeNoteIntent)
        }
    }
}