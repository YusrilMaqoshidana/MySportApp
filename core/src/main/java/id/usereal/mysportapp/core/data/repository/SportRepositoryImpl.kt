package id.usereal.mysportapp.core.data.repository

import id.usereal.mysportapp.core.data.NetworkBoundResource
import id.usereal.mysportapp.core.data.Resource
import id.usereal.mysportapp.core.data.local.LocalDataSource
import id.usereal.mysportapp.core.data.remote.RemoteDataSource
import id.usereal.mysportapp.core.data.remote.response.TeamsItem
import id.usereal.mysportapp.core.data.remote.retrofit.ApiResponse
import id.usereal.mysportapp.core.domain.model.Sport
import id.usereal.mysportapp.core.domain.repository.ISportRepository
import id.usereal.mysportapp.core.utils.AppExecutors
import id.usereal.mysportapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SportRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISportRepository {
    override fun getAllTeam(): Flow<Resource<List<Sport>>> =
        object : NetworkBoundResource<List<Sport>, List<TeamsItem>>() {
            override fun loadFromDB(): Flow<List<Sport>> {
                return localDataSource.getAllSport().map {
                    DataMapper.mapEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Sport>?): Boolean = data.isNullOrEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<TeamsItem>>> = remoteDataSource.getAllTeams()


            override suspend fun saveCallResult(data: List<TeamsItem>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSport(teamList)
            }
        }.asFlow()

    override fun getFavoriteTeam(): Flow<List<Sport>> = localDataSource.getFavoriteSport().map {
        DataMapper.mapEntityToDomain(it)
    }

    override fun setFavoriteTeam(team: Sport, state: Boolean) {
        val sportEntity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.setFavoriteSport(sportEntity, state) }
    }
}