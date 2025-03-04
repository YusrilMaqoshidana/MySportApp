package id.usereal.mysportapp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.usereal.mysportapp.core.data.repository.SportRepositoryImpl
import id.usereal.mysportapp.core.domain.repository.ISportRepository

@Module(includes = [RemoteModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(sportRepository: SportRepositoryImpl): ISportRepository

}