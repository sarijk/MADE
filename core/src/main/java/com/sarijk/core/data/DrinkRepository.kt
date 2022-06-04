package com.sarijk.core.data

import com.sarijk.core.data.source.local.LocalDataSource
import com.sarijk.core.data.source.remote.RemoteDataSource
import com.sarijk.core.data.source.remote.network.ApiResponse
import com.sarijk.core.data.source.remote.response.DrinkResponse
import com.sarijk.core.domain.model.Drink
import com.sarijk.core.domain.repository.IDrinkRepository
import com.sarijk.core.utils.AppExecutors
import com.sarijk.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IDrinkRepository {

    override fun getAllDrink(): Flow<Resource<List<Drink>>> =
        object : NetworkBoundResource<List<Drink>, List<DrinkResponse>>() {
            override fun loadFromDB(): Flow<List<Drink>> {
                return localDataSource.getAllDrink().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Drink>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<DrinkResponse>>> =
                remoteDataSource.getAllDrink()

            override suspend fun saveCallResult(data: List<DrinkResponse>) {
                val drinkList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertDrink(drinkList)
            }
        }.asFlow()

    override fun getFavoriteDrink(): Flow<List<Drink>> {
        return localDataSource.getFavoriteDrink().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteDrink(drink: Drink, state: Boolean) {
        val drinkEntity = DataMapper.mapDomainToEntity(drink)
        appExecutors.diskIO().execute { localDataSource.setFavoriteDrink(drinkEntity, state) }
    }
}

