package android.maxim.contacts.ui.addscreen

import android.maxim.contacts.model.database.Contact
import android.maxim.contacts.model.repository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddViewModel (private val repository: Repository): ViewModel() {

    private var firstName: String = ""
    private var lastName: String = ""
    private var phoneNumber: String = ""
    private var email: String = ""

    val contact = Contact(
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email
    )

    fun addContact() {
        repository.insertContact(contact)
    }
}

