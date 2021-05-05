package sam.samyups1111.notes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import sam.samyups1111.notes.R
import sam.samyups1111.notes.model.Note
import sam.samyups1111.notes.util.MainApplication
import sam.samyups1111.notes.util.MainViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class WriteNoteActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as MainApplication).mainRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_note)
        supportActionBar?.hide()
        initBottomNavigationMenu()
        uploadNote()
    }

    override fun onDestroy() {
        saveNote()
        super.onDestroy()
    }

    private fun saveNote() {
        val title = findViewById<EditText>(R.id.write_title_edittext).text.toString()
        val message = findViewById<EditText>(R.id.write_note_edittext).text.toString()
        var id = findViewById<TextView>(R.id.write_id_edittext).text.toString().toInt()
        val newId = (0..1000000000).random()
        if (id < 1) {
            id = newId

            if (title != "") {
                val thisNote = Note(title, message, id)
                viewModel.addNote(thisNote)
            }
        } else {
                if (title != "") {
                    val thisNote = Note(title, message, id)
                    viewModel.updateNote(thisNote)
                }
        }
    }

    private fun uploadNote() {
        val currentNoteTitle = intent.getStringExtra("title").toString()
        val currentNoteMessage = intent.getStringExtra("message").toString()
        val currentNoteId = intent.getStringExtra("id")?.toInt().toString()

        if (currentNoteTitle != "null") {
            findViewById<EditText>(R.id.write_title_edittext).setText(currentNoteTitle)
            findViewById<EditText>(R.id.write_note_edittext).setText(currentNoteMessage)
            findViewById<TextView>(R.id.write_id_edittext).setText(currentNoteId)
        }
    }

    private fun initBottomNavigationMenu() {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation_menu)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_menu -> {
                    saveNote()
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}