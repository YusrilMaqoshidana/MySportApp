package id.usereal.mysportapp.core.domain.repository

import id.usereal.mysportapp.core.data.Resource
import id.usereal.mysportapp.core.data.remote.response.TeamsItem
import kotlinx.coroutines.flow.Flow

interface ISportRepository {

    fun getAllTeam(): Flow<Resource<List<TeamsItem>>>

    fun getFavoriteTeam(): Flow<List<TeamsItem>>

    fun setFavoriteTeam(tourism: TeamsItem, state: Boolean)

}