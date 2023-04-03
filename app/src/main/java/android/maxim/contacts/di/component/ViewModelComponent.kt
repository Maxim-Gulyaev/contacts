package android.maxim.contacts.di.component

import android.maxim.contacts.di.module.ViewModelModule
import android.maxim.contacts.ui.addscreen.AddViewModel
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface ViewModelComponent {
    fun injectAddViewModel(addViewModel: AddViewModel)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelComponent
    }
}