package id.usereal.mysportapp.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import id.usereal.mysportapp.core.data.local.entity.SportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {

    @Query("SELECT * FROM sport")
    fun getAllTeams(): Flow<List<SportEntity>>

    @Query("SELECT * FROM sport where isFavorite = 1")
    fun getFavoriteTeams(): Flow<List<SportEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team: List<SportEntity>)

    @Update
    fun updateFavoriteTeam(team: SportEntity)

}