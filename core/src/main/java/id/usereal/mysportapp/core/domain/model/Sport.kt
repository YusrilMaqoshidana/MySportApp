package id.usereal.mysportapp.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sport(

    val id: String,

    val name: String,

    val image: String,

    val league: String,

    val since: String,

    val location: String,

    val nameAlternative: String,

    val stadium: String,

    val stadiumCapacity: String,

    val description: String,

    var isFavorite: Boolean = false
) : Parcelable