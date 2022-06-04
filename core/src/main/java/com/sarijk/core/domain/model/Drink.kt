package com.sarijk.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    val id: String,
    val image: String,
    val category: String,
    val name: String,
    val instructions: String,
    var favorite: Boolean,
) : Parcelable