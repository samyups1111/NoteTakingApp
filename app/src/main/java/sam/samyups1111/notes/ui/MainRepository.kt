package sam.samyups1111.notes.ui

import androidx.annotation.WorkerThread
import sam.samyups1111.notes.model.MainDao
import sam.samyups1111.notes.model.Note
import kotlinx.coroutines.flow.Flow

class MainRepository(private val mainDao: MainDao) {

    val getNotes: Flow<List<Note>> = mainDao.getNotes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addNote(note: Note) {
        mainDao.addNote(note)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(note: Note) {
        mainDao.delete(note)
    }

    suspend fun updateNote(note: Note) {
        mainDao.updateNote(note)
    }
}