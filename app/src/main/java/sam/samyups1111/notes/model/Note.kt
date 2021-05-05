package sam.samyups1111.notes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Note(
        val title: String,
        val message: String,
        @PrimaryKey val id : Int
)

