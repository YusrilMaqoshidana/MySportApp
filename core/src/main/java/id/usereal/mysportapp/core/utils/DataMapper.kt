package id.usereal.mysportapp.core.utils

import id.usereal.mysportapp.core.data.local.entity.SportEntity
import id.usereal.mysportapp.core.data.remote.response.SportResponse
import id.usereal.mysportapp.core.data.remote.response.TeamsItem

object DataMapper {
    fun mapResponsesToEntities(input: List<TeamsItem>): List<SportEntity> {
        return input.map {
            SportEntity(
                id = it.idTeam,
                name = it.strTeam,
                image = it.strBadge,
                league = it.strLeague,
                since = it.intFormedYear,
                location = it.strLocation,
                nameAlternative = it.strTeamAlternate,
                stadium = it.strStadium,
                stadiumCapacity = it.intStadiumCapacity,
                description = it.strDescriptionEN,
                isFavorite = false
            )
        }
    }

}