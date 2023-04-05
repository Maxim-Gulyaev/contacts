package android.maxim.contacts.di.module

import android.app.Application
import android.maxim.contacts.model.repository.Repository
import android.maxim.contacts.ui.addscreen.AddViewModelFactory
import android.maxim.contacts.ui.listscreen.ListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    //
    @Provides
    fun provideAddViewModelFactory(repository: Repository): AddViewModelFactory {
        return AddViewModelFactory(
            repository = repository
        )
    }

    @Provides
    fun provideListViewModelFactory(repository: Repository): ListViewModelFactory {
        return ListViewModelFactory(
            repository = repository
        )
    }

    @Provides
    fun provideApplication(): Application {
        return Application()
    }
}