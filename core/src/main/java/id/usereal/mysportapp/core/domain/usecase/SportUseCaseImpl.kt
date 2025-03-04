package id.usereal.mysportapp.core.domain.usecase

import id.usereal.mysportapp.core.data.Resource
import id.usereal.mysportapp.core.domain.model.Sport
import id.usereal.mysportapp.core.domain.repository.ISportRepository
import id.usereal.mysportapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SportUseCaseImpl @Inject constructor(private val sportRepository: ISportRepository) : ISportUseCase {
    override fun getAllTeam(): Flow<Resource<List<Sport>>> {
        return sportRepository.getAllTeam()
    }

    override fun getFavoriteTeam(): Flow<List<Sport>> {
        return sportRepository.getFavoriteTeam()
    }

    override fun setFavoriteTeam(sport: Sport, state: Boolean) {
        return sportRepository.setFavoriteTeam(sport, state)
    }
}