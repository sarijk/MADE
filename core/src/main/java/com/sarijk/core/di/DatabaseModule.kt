package com.sarijk.core.di

import android.content.Context
import androidx.room.Room
import com.sarijk.core.data.source.local.room.DrinkDao
import com.sarijk.core.data.source.local.room.DrinkDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DrinkDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("sarijk".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            DrinkDatabase::class.java, "Drink.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideDrinkDao(database: DrinkDatabase): DrinkDao = database.drinkDao()
}