package com.sarijk.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_drink")
data class DrinkEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idDrink")
    val id: String,

    @ColumnInfo(name = "strDrinkThumb")
    val image: String,

    @ColumnInfo(name = "strCategory")
    val category: String,

    @ColumnInfo(name = "strDrink")
    val name: String,

    @ColumnInfo(name = "strInstructions")
    val instructions: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
)
