package android.maxim.contacts.di

import android.maxim.contacts.model.database.ContactDao
import android.maxim.contacts.model.database.ContactDaoImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindContactDao(contactDaoImpl: ContactDaoImpl): ContactDao
}