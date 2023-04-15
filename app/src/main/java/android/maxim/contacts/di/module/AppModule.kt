package android.maxim.contacts.di.module

import android.app.Application
import android.content.Context
import android.maxim.contacts.model.database.ContactDao
import android.maxim.contacts.model.database.ContactsDatabase
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideApplication(): Application {
        return Application()
    }

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideContactDao(contactsDatabase: ContactsDatabase): ContactDao {
        return contactsDatabase.contactDao()
    }

    @Provides
    fun provideContactsDatabase(): ContactsDatabase {
        return ContactsDatabase.getInstance(context)!!
    }

    @Provides
    fun provideDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}