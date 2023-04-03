package android.maxim.contacts.ui.addscreen

import android.maxim.contacts.di.component.AppComponent
import android.maxim.contacts.di.component.DaggerAppComponent
import android.maxim.contacts.model.database.Contact
import android.maxim.contacts.model.repository.Repository
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AddViewModel (private val repository: Repository): ViewModel() {

    private val appComponent: AppComponent = DaggerAppComponent.create()
    private val viewModelComponent = appComponent
        .viewModelComponent()
        .injectAddViewModel(this)

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

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
        compositeDisposable.add(
            Observable.just(contact)
                .subscribeOn(Schedulers.io())
                .subscribe {repository.insertContact(contact)}
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}

