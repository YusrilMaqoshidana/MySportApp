package id.usereal.mysportapp.core.utils

import id.usereal.mysportapp.core.data.local.entity.SportEntity
import id.usereal.mysportapp.core.data.remote.response.TeamsItem
import id.usereal.mysportapp.core.domain.model.Sport

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

    fun mapEntityToDomain(input: List<SportEntity>): List<Sport> {
        return input.map {
            Sport(
                id = it.id,
                name = it.name,
                image = it.image,
                league = it.league,
                since = it.since,
                location = it.location,
                nameAlternative = it.nameAlternative,
                stadium = it.stadium,
                stadiumCapacity = it.stadiumCapacity,
                description = it.description,
                isFavorite = it.isFavorite
            )
        }
    }
    fun mapDomainToEntity(input: Sport) = SportEntity(
        id = input.id,
        name = input.name,
        image = input.image,
        league = input.league,
        since = input.since,
        location = input.location,
        nameAlternative = input.nameAlternative,
        stadium = input.stadium,
        stadiumCapacity = input.stadiumCapacity,
        description = input.description,
        isFavorite = input.isFavorite
    )

}