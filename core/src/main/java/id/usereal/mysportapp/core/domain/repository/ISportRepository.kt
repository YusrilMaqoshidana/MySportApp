package id.usereal.mysportapp.core.domain.repository

import id.usereal.mysportapp.core.data.Resource
import id.usereal.mysportapp.core.data.remote.response.TeamsItem
import id.usereal.mysportapp.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface ISportRepository {

    fun getAllTeam(): Flow<Resource<List<Sport>>>

    fun getFavoriteTeam(): Flow<List<Sport>>

    fun setFavoriteTeam(team: Sport, state: Boolean)

}