package com.sarijk.core.domain.usecase

import com.sarijk.core.domain.model.Drink
import com.sarijk.core.domain.repository.IDrinkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DrinkInteractor @Inject constructor(private val drinkRepository: IDrinkRepository):
    DrinkUseCase {

    override fun getAllDrink() = drinkRepository.getAllDrink()

    override fun getFavoriteDrink() = drinkRepository.getFavoriteDrink()

    override fun setFavoriteDrink(drink: Drink, state: Boolean) = drinkRepository.setFavoriteDrink(drink, state)
    override fun searchDrink(value: String): Flow<List<Drink>> {
        TODO("Not yet implemented")
    }
}