package android.maxim.contacts.di

import android.maxim.contacts.model.repository.Repository
import android.maxim.contacts.ui.addscreen.AddViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideAddViewModelFactory(repository: Repository): AddViewModelFactory {
        return AddViewModelFactory(
            repository = repository
        )
    }
}