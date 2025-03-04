package id.usereal.mysportapp.core.domain.usecase

import id.usereal.mysportapp.core.data.Resource
import id.usereal.mysportapp.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface ISportUseCase {
    fun getAllTeam(): Flow<Resource<List<Sport>>>
    fun getFavoriteTeam(): Flow<List<Sport>>
    fun setFavoriteTeam(sport: Sport, state: Boolean)
}