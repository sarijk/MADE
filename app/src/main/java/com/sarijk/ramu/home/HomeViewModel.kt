package com.sarijk.ramu.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sarijk.core.domain.usecase.DrinkUseCase

class HomeViewModel @ViewModelInject constructor(drinkUseCase: DrinkUseCase) : ViewModel() {
    val drink = drinkUseCase.getAllDrink().asLiveData()
}