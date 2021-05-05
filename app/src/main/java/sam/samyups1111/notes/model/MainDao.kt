package sam.samyups1111.notes.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {

    @Query("SELECT * FROM `Notes` ORDER BY title COLLATE NOCASE ASC")
    fun getNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun updateNote(note: Note)
}