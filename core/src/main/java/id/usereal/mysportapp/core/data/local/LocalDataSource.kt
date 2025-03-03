package id.usereal.mysportapp.core.data.local

import id.usereal.mysportapp.core.data.local.entity.SportEntity
import id.usereal.mysportapp.core.data.local.room.SportDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val sportDao: SportDao) {
    fun getAllSport(): Flow<List<SportEntity>> = sportDao.getAllTeams()

    fun getFavoriteSport(): Flow<List<SportEntity>> = sportDao.getFavoriteTeams()

    suspend fun insertSport(sportList: List<SportEntity>) = sportDao.insertTeam(sportList)

    fun setFavoriteSport(sport: SportEntity, newState: Boolean) {
        sport.isFavorite = newState
        sportDao.updateFavoriteTeam(sport)
    }
}