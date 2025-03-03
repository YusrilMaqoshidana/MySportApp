package id.usereal.mysportapp.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class SportEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
)