package android.maxim.contacts.di.component


import android.maxim.contacts.di.module.ViewModelModule
import android.maxim.contacts.ui.addscreen.AddViewModel
import android.maxim.contacts.ui.listscreen.ListViewModel
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface ViewModelComponent {

    fun injectAddViewModel(addViewModel: AddViewModel)
    fun injectListViewModel(listViewModel: ListViewModel)
}
