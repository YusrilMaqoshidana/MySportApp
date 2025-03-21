package id.usereal.mysportapp.favorite.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.usereal.mysportapp.core.domain.usecase.ISportUseCase
import id.usereal.mysportapp.core.domain.usecase.SportUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
class FavoriteModule {

    @Provides
    fun provideUseCase(sportUseCase: SportUseCaseImpl): ISportUseCase {
        return sportUseCase
    }
}

