package id.usereal.mysportapp.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sport")
data class SportEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "league")
    val league: String,

    @ColumnInfo(name = "since")
    val since: String,

    @ColumnInfo(name = "location")
    val location: String,

    @ColumnInfo(name = "name_alternative")
    val nameAlternative: String,

    @ColumnInfo(name = "stadium")
    val stadium: String,

    @ColumnInfo(name = "stadium_capacity")
    val stadiumCapacity: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)