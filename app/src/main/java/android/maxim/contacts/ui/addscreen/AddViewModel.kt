package android.maxim.contacts.ui.addscreen

import android.maxim.contacts.app.App
import android.maxim.contacts.di.component.DaggerAppComponent
import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.model.database.Contact
import android.maxim.contacts.model.repository.Repository
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AddViewModel: ViewModel() {

    init {
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(App().getAppContext()))
            .build()
        appComponent.injectAddViewModel(this)
    }

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var repository: Repository

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

