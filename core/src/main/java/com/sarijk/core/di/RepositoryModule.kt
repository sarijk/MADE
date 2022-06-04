package com.sarijk.core.di

import com.sarijk.core.data.DrinkRepository
import com.sarijk.core.domain.repository.IDrinkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(drinkRepository: DrinkRepository): IDrinkRepository

}