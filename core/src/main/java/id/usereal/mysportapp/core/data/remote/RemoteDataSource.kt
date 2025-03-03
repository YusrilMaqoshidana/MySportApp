package id.usereal.mysportapp.core.data.remote

import android.util.Log
import id.usereal.mysportapp.core.data.remote.response.SportResponse
import id.usereal.mysportapp.core.data.remote.response.TeamsItem
import id.usereal.mysportapp.core.data.remote.retrofit.ApiResponse
import id.usereal.mysportapp.core.data.remote.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllTeams() : Flow<ApiResponse<List<TeamsItem>>> {
        return flow {
            try {
                val response = apiService.getList()
                val result = response.teams
                if (result.isNotEmpty()){
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: HttpException){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}