package sam.samyups1111.notes.util

import android.app.Application
import sam.samyups1111.notes.model.MainDatabase
import sam.samyups1111.notes.ui.MainRepository

class MainApplication: Application() {

    private val mainDatabase by lazy { MainDatabase.getInstance(this) }

    val mainRepository by lazy { MainRepository(mainDatabase.mainDao()) }
}