package id.usereal.mysportapp.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.usereal.mysportapp.core.data.local.entity.SportEntity

@Database(entities = [SportEntity::class], version = 1, exportSchema = false)
abstract class SportDatabase : RoomDatabase() {
    abstract fun sportDao(): SportDao
}