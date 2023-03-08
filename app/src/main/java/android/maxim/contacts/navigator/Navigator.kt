package android.maxim.contacts.navigator

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun showContactDetails()

    fun addContact()

    fun cancel()

    fun saveNewContact()

    fun backToContactList()

    fun editContact()

    fun deleteContact()

    fun call()

    fun sendSms()

    fun saveEditedContact()

}