package com.sarijk.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sarijk.core.data.source.local.entity.DrinkEntity

@Database(entities = [DrinkEntity::class], version = 1, exportSchema = false)
abstract class DrinkDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao

}