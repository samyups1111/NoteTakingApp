package sam.samyups1111.notes.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sam.samyups1111.notes.R
import sam.samyups1111.notes.model.Note

class MainRecyclerAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var notesList: List<Note> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentNote = notesList[position]
        holder.bind(currentNote)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun update(list : List<Note>) {
        this.notesList = list
        notifyDataSetChanged()
    }
}