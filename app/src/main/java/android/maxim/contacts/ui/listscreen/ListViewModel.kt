package android.maxim.contacts.ui.listscreen

import android.maxim.contacts.app.App
import android.maxim.contacts.di.component.DaggerAppComponent
import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.model.database.Contact
import android.maxim.contacts.model.repository.Repository
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
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
    lateinit var listContacts: List<Contact>

    //TODO: Find way to dispose it.
    fun getContactList(): Single<List<Contact>> {
        return repository.getContact()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { Single.just(it) }
            .doOnSuccess { listContacts = it }
    }
}