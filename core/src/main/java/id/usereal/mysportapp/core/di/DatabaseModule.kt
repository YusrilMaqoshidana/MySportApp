package id.usereal.mysportapp.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.usereal.mysportapp.core.data.local.room.SportDao
import id.usereal.mysportapp.core.data.local.room.SportDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SportDatabase = Room.databaseBuilder(
        context,
        SportDatabase::class.java, "Sport.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: SportDatabase): SportDao = database.sportDao()
}