package android.maxim.contacts.ui.listscreen

import android.maxim.contacts.app.App
import android.maxim.contacts.di.component.DaggerAppComponent
import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.model.database.Contact
import android.maxim.contacts.model.repository.Repository
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class ListViewModel: ViewModel() {

    init {
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(App().getAppContext()))
            .build()
        appComponent.injectListViewModel(this)
    }

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var repository: Repository


    var listContacts: List<Contact> = getContactList()

    fun getContactList(): List<Contact> {
        //this returns null
           /* repository.getContact()
                .subscribeOn(Schedulers.io())
                .map { it -> listContacts = it }
        return listContacts*/
        //hardcoded it temporary
        val listContact = listOf(
            Contact(null, "aaa", "bbb","333", "ccc"),
            Contact(null,"bbb","bbb","333","bbb"))
        return listContact
    }

    /*fun getContactList(): Single<List<Contact>> {
        return repository.getContact()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }*/

    /*fun getContactList(): List<Contact> {
        return repository.getContact()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .blockingGet()
    }*/


}