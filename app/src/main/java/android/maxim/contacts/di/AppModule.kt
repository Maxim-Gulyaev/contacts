package android.maxim.contacts.di

import android.app.Application
import android.content.Context
import android.maxim.contacts.model.repository.Repository
import android.maxim.contacts.ui.addscreen.AddViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context, repository: Repository) {

    @Provides
    fun provideAddViewModelFactory(repository: Repository): AddViewModelFactory {
        return AddViewModelFactory(
            repository = repository
        )
    }

    @Provides
    fun provideApplication(): Application {
        return Application()
    }

    @Provides
    fun provideContext(): Context = context
}