package android.maxim.contacts.di.component

import android.maxim.contacts.di.module.AppModule
import android.maxim.contacts.model.repository.Repository
import android.maxim.contacts.ui.addscreen.AddFragment
import android.maxim.contacts.ui.addscreen.AddViewModel
import android.maxim.contacts.ui.listscreen.ListFragment
import android.maxim.contacts.ui.listscreen.ListViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectAddFragment(addFragment: AddFragment)

    fun injectListFragment(listFragment: ListFragment)

    fun injectAddViewModel(addViewModel: AddViewModel)

    fun injectListViewModel(listViewModel: ListViewModel)

    fun injectRepository(repository: Repository)

    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}