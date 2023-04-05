package android.maxim.contacts.di.component

import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.di.module.DataModule
import android.maxim.contacts.ui.addscreen.AddFragment
import android.maxim.contacts.ui.listscreen.ListFragment
import dagger.Component

@Component(modules = [DataModule::class, AppModule::class])
interface AppComponent {

    fun injectAddFragment(addFragment: AddFragment)

    fun injectListFragment(listFragment: ListFragment)

    fun viewModelComponent(): ViewModelComponent
}