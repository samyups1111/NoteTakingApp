package sam.samyups1111.notes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import sam.samyups1111.notes.model.Note
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    var getNotes: LiveData<List<Note>> = mainRepository.getNotes.asLiveData()

    fun addNote(note: Note) = viewModelScope.launch {
        mainRepository.addNote(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        mainRepository.delete(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        mainRepository.updateNote(note)
    }
}