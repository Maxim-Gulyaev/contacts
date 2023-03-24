package android.maxim.contacts.di

import android.maxim.contacts.ui.activity.MainActivity
import android.maxim.contacts.ui.addscreen.AddFragment
import dagger.Component

@Component(modules = [DataModule::class, AppModule::class])
interface AppComponent {

    fun injectAddFragment(addFragment: AddFragment)
}