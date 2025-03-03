package id.usereal.mysportapp.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse(

	@field:SerializedName("teams")
	val teams: List<TeamsItem> = emptyList()
)

data class TeamsItem(

	@field:SerializedName("idTeam")
	val idTeam: String,

	@field:SerializedName("strTeam")
	val strTeam: String,

	@field:SerializedName("strTeamAlternate")
	val strTeamAlternate: String,

	@field:SerializedName("intFormedYear")
	val intFormedYear: String,

	@field:SerializedName("strLeague")
	val strLeague: String,

	@field:SerializedName("strStadium")
	val strStadium: String,

	@field:SerializedName("intStadiumCapacity")
	val intStadiumCapacity: String,

	@field:SerializedName("strLocation")
	val strLocation: String,

	@field:SerializedName("strBadge")
	val strBadge: String,

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: String
)

