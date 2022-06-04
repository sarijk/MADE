package com.sarijk.core.data.source.local.room

import androidx.room.*
import com.sarijk.core.data.source.local.entity.DrinkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DrinkDao {

    @Query("SELECT * FROM tb_drink")
    fun getAllDrink(): Flow<List<DrinkEntity>>

    @Query("SELECT * FROM tb_drink where favorite = 1")
    fun getFavoriteDrink(): Flow<List<DrinkEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: List<DrinkEntity>)

    @Update
    fun updateFavoriteDrink(drink: DrinkEntity)
}
