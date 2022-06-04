package com.sarijk.ramu.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.sarijk.core.domain.model.Drink
import com.sarijk.core.domain.usecase.DrinkUseCase

class DetailDrinkViewModel @ViewModelInject constructor(private val drinkUseCase: DrinkUseCase) : ViewModel() {
    fun setFavoriteDrink(drink: Drink, newStatus:Boolean) =
        drinkUseCase.setFavoriteDrink(drink, newStatus)
}