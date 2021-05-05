package sam.samyups1111.notes.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sam.samyups1111.notes.ui.MainRepository
import sam.samyups1111.notes.ui.MainViewModel

class MainViewModelFactory(private val mainRepository: MainRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepository) as T
    }
}