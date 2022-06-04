package com.sarijk.core.data.source.local

import com.sarijk.core.data.source.local.entity.DrinkEntity
import com.sarijk.core.data.source.local.room.DrinkDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val drinkDao: DrinkDao) {

    fun getAllDrink(): Flow<List<DrinkEntity>> = drinkDao.getAllDrink()

    fun getFavoriteDrink(): Flow<List<DrinkEntity>> = drinkDao.getFavoriteDrink()

    suspend fun insertDrink(drinkList: List<DrinkEntity>) = drinkDao.insertDrink(drinkList)

    fun setFavoriteDrink(drink: DrinkEntity, newState: Boolean) {
        drink.favorite = newState
        drinkDao.updateFavoriteDrink(drink)
    }
}