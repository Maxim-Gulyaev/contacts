package android.maxim.contacts.di.component

import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.di.module.DataModule
import android.maxim.contacts.ui.addscreen.AddFragment
import dagger.Component

@Component(modules = [DataModule::class, AppModule::class])
interface AppComponent {

    fun injectAddFragment(addFragment: AddFragment)

    fun viewModelComponent(): ViewModelComponent
}