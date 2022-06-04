package com.sarijk.core.utils

import com.sarijk.core.data.source.local.entity.DrinkEntity
import com.sarijk.core.data.source.remote.response.DrinkResponse
import com.sarijk.core.domain.model.Drink

object DataMapper {
    fun mapResponsesToEntities(input: List<DrinkResponse>): List<DrinkEntity> {
        val tourismList = ArrayList<DrinkEntity>()
        input.map {
            val tourism = DrinkEntity(
                id = it.id,
                image = it.image,
                category = it.category,
                name = it.name,
                instructions = it.instructions,
                favorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<DrinkEntity>): List<Drink> =
        input.map {
            Drink(
                id = it.id,
                image = it.image,
                category = it.category,
                name = it.name,
                instructions = it.instructions,
                favorite = it.favorite
            )
        }

    fun mapDomainToEntity(input: Drink) = DrinkEntity(
        id = input.id,
        image = input.image,
        category = input.category,
        name = input.name,
        instructions = input.instructions,
        favorite = input.favorite
    )
}