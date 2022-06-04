package com.sarijk.ramu.di

import com.sarijk.core.domain.usecase.DrinkUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface FavoriteModuleDependencies {

    fun drinkUseCase(): DrinkUseCase
}