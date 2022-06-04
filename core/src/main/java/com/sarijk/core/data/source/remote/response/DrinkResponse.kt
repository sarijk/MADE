package com.sarijk.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DrinkResponse(
    @field:SerializedName("idDrink")
    val id: String,

    @field:SerializedName("strDrinkThumb")
    val image: String,

    @field:SerializedName("strCategory")
    val category: String,

    @field:SerializedName("strDrink")
    val name: String,

    @field:SerializedName("strInstructions")
    val instructions: String,
)

