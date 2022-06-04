package com.sarijk.ramu.di

import com.sarijk.core.domain.usecase.DrinkInteractor
import com.sarijk.core.domain.usecase.DrinkUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideDrinkRepository(drinkInteractor: DrinkInteractor): DrinkUseCase
}
