package id.usereal.mysportapp.core.data.repository

import id.usereal.mysportapp.core.data.NetworkBoundResource
import id.usereal.mysportapp.core.data.Resource
import id.usereal.mysportapp.core.data.local.LocalDataSource
import id.usereal.mysportapp.core.data.remote.RemoteDataSource
import id.usereal.mysportapp.core.data.remote.response.TeamsItem
import id.usereal.mysportapp.core.data.remote.retrofit.ApiResponse
import id.usereal.mysportapp.core.domain.repository.ISportRepository
import id.usereal.mysportapp.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SportRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISportRepository {
    override fun getAllTeam(): Flow<Resource<List<TeamsItem>>> =
        object : NetworkBoundResource<List<TeamsItem>, List<TeamsItem>>(),
            Flow<Resource<List<TeamsItem>>> {
            override fun loadFromDB(): Flow<List<TeamsItem>> {
                TODO("Not yet implemented")
            }

            override suspend fun createCall(): Flow<ApiResponse<List<TeamsItem>>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: List<TeamsItem>) {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: List<TeamsItem>?): Boolean {
                TODO("Not yet implemented")
            }

            override fun getFavoriteTeam(): Flow<List<TeamsItem>> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteTeam(tourism: TeamsItem, state: Boolean) {
        TODO("Not yet implemented")
    }

            override suspend fun collect(collector: FlowCollector<Resource<List<TeamsItem>>>) {
                TODO("Not yet implemented")
            }
        }