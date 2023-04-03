package android.maxim.contacts.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
class ViewModelModule {

    @Provides
    fun provideDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}
