package android.maxim.contacts.ui.listscreen

import android.maxim.contacts.model.repository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListViewModelFactory (private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}